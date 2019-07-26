package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {

    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField = 0;
    private int countFlags = 0;
    private boolean isGameStopped;
    private int countClosedTiles = SIDE * SIDE;
    private int score = 0;

    @Override
    public void initialize() {

        setScreenSize(SIDE, SIDE);

        createGame();
    }

    private void createGame() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                boolean isMine = false;
                if (getRandomNumber(10) == 7) {
                    isMine = true;
                    countMinesOnField++;
                }
                gameField[j][i] = new GameObject(i, j, isMine);
                setCellValue(i ,j, "");
                setCellColor(i, j, Color.GREY);
            }
        }
        countFlags = countMinesOnField;
        countMineNeighbors();

    }

    private void countMineNeighbors() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (!gameField[j][i].isMine) {
                    List<GameObject> neighbors = getNeighbors(gameField[j][i]);
                    for (GameObject neighbor: neighbors) {
                        if (neighbor.isMine) {
                            gameField[j][i].countMineNeighbors++;
                        }
                    }
                }
            }
        }
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> listNeighbors = new ArrayList<>();

        if (gameObject.x - 1 >= 0) listNeighbors.add(gameField[gameObject.y][gameObject.x-1]);
        if (gameObject.y - 1 >= 0) listNeighbors.add(gameField[gameObject.y-1][gameObject.x]);
        if (gameObject.x + 1 < SIDE) listNeighbors.add(gameField[gameObject.y][gameObject.x+1]);
        if (gameObject.y + 1 < SIDE) listNeighbors.add(gameField[gameObject.y+1][gameObject.x]);
        if (gameObject.x - 1 >= 0 && gameObject.y - 1 >= 0) listNeighbors.add(gameField[gameObject.y-1][gameObject.x-1]);
        if (gameObject.y - 1 >= 0 && gameObject.x + 1 < SIDE) listNeighbors.add(gameField[gameObject.y-1][gameObject.x+1]);
        if (gameObject.x + 1 < SIDE && gameObject.y + 1 < SIDE) listNeighbors.add(gameField[gameObject.y+1][gameObject.x+1]);
        if (gameObject.y + 1 < SIDE && gameObject.x - 1 >= 0) listNeighbors.add(gameField[gameObject.y+1][gameObject.x-1]);

        return listNeighbors;
    }

    private void openTile(int x, int y) {
        if (!isGameStopped) {
            GameObject cell = gameField[y][x];
            if (cell.isFlag) {
                return;
            }
            if (cell.isOpen) {
                return;
            }
            cell.isOpen = true;
            setCellColor(x, y, Color.LIGHTGREY);
            countClosedTiles--;
            if (cell.isMine) {
                setCellValueEx(x, y, Color.RED, MINE);
                gameOver();
            } else {
                if (cell.countMineNeighbors == 0) {
                    List<GameObject> neighbors = getNeighbors(cell);
                    setCellValue(x, y, "");
                    for (GameObject neighbor : neighbors) {
                        if (!neighbor.isOpen) {
                            openTile(neighbor.x, neighbor.y);
                        }
                    }
                } else {
                    setCellNumber(x, y, cell.countMineNeighbors);
                }
                score += 5;
                setScore(score);
                if (countClosedTiles == countMinesOnField) {
                    win();
                }
            }
        }
    }

    private void markTile(int x, int y) {
        GameObject cell = gameField[y][x];
        if (!isGameStopped) {
            if (!cell.isOpen) {
                if (!cell.isFlag) {
                    if (countFlags > 0) {
                        cell.isFlag = true;
                        countFlags--;
                        setCellValue(x, y, FLAG);
                        setCellColor(x, y, Color.WHITESMOKE);
                    }
                } else {
                    cell.isFlag = false;
                    countFlags++;
                    setCellValue(x, y, "");
                    setCellColor(x, y, Color.GREY);
                }
            }
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.LIGHTGOLDENRODYELLOW, "You died!", Color.BLACK, 14);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.LIGHTGOLDENRODYELLOW, "You win!", Color.BLACK, 14);
    }

    private void restart() {
        isGameStopped = false;
        score = 0;
        setScore(score);
        countMinesOnField = 0;
        countClosedTiles = SIDE * SIDE;
        createGame();
    }


    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) {
            restart();
        } else {
            openTile(x, y);
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    public static void main(String[] args) {

    }

}