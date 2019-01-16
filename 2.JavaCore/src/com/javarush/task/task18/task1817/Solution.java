package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        int charCount = 0;
        int spaceCount = 0;
        FileInputStream inputStream = new FileInputStream(args[0]);
        while (inputStream.available() > 0) {
            int letter = inputStream.read();
            charCount++;
            if (letter == 32) {
                spaceCount++;
            }
        }
        float result = (float) spaceCount / charCount * 100;
        inputStream.close();

        System.out.println(String.format("%.2f", result));
    }
}
