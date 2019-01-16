package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        int colonCounter = 0;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();

            FileInputStream inputStream = new FileInputStream(fileName);
            while (inputStream.available() > 0) {
                int charCode = inputStream.read();
                if (charCode == ((int) ',')) {
                    colonCounter++;
                }
            }
            inputStream.close();
        } catch (Exception e) {

        }
        System.out.println(colonCounter);
    }
}
