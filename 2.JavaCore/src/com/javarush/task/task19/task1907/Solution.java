package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();

        int num = 0;
        String word = "";
        while (fileReader.ready()) {
            char letter = (char) fileReader.read();
            if (Character.isAlphabetic(letter)) {
                word += letter;
            } else {
                if ("world".equals(word)) {
                    num++;
                }
                word = "";

            }
        }

        fileReader.close();

        System.out.println(num);
    }
}
