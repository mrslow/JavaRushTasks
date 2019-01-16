package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String inputFile = reader.readLine();
            String firstOutputFile = reader.readLine();
            String secondOutputFile = reader.readLine();
            reader.close();

            FileInputStream inputStream = new FileInputStream(inputFile);
            int half = (inputStream.available() % 2 == 0) ? (inputStream.available() / 2) : (inputStream.available() / 2) + 1;
            byte[] firstBuffer = new byte[half];
            byte[] secondBuffer = new byte[half];


            FileOutputStream firstOutputStream = new FileOutputStream(firstOutputFile);
            int firstCount = inputStream.read(firstBuffer);
            firstOutputStream.write(firstBuffer, 0, firstCount);
            firstOutputStream.close();

            FileOutputStream secondOutputStream = new FileOutputStream(secondOutputFile);
            int secondCount = inputStream.read(secondBuffer);
            secondOutputStream.write(secondBuffer, 0 , secondCount);
            secondOutputStream.close();

            inputStream.close();
        } catch (Exception e) {

        }
    }
}
