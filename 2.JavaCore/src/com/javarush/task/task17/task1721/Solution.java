package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = null;
        String secondFile = null;
        try {
            firstFile = reader.readLine();
            secondFile = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        readContent(firstFile, allLines);
        readContent(secondFile, forRemoveLines);

        try {
            new Solution().joinData();
        } catch (CorruptedDataException e) {

        }

    }

    public void joinData() throws CorruptedDataException {
        boolean isCorrupted = false;
        for (String line : forRemoveLines) {
            if (allLines.indexOf(line) < 0) {
                isCorrupted = true;
            }
            if (isCorrupted) {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }

        allLines.removeAll(forRemoveLines);
    }

    private static void readContent(String filePath, List<String> list) {
        try {
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            while (fileReader.ready()) {
                list.add(fileReader.readLine());
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
