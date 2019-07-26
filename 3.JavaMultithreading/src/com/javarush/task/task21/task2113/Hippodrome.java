package com.javarush.task.task21.task2113;


import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {

        game = new Hippodrome(new ArrayList<>());
        game.horses.add(new Horse("Bender", 3, 0));
        game.horses.add(new Horse("Leela", 3, 0));
        game.horses.add(new Horse("Zoidberg", 3, 0));
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i=1; i<=100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse: horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse: horses) {
            horse.print();
        }
        for (int i=0; i<10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = horses.get(0);
        for (int i=1; i<=horses.size()-1; i++) {
            if (horses.get(i).distance > horses.get(i-1).distance) {
                winner = horses.get(i);
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().name + "!");
    }
}
