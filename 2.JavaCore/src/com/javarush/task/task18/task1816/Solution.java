package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {

        int charCount = 0;
        FileInputStream inputStream = new FileInputStream(args[0]);
        while (inputStream.available() > 0) {
            int letter = inputStream.read();
            if (64 < letter && letter <123) {
                charCount++;
            }
        }
        inputStream.close();

        System.out.println(charCount);
    }
}
