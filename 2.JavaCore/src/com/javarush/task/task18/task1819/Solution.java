package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String firstFile = reader.readLine();
            String secondFile = reader.readLine();
            reader.close();

            FileInputStream firstFileInputStream = new FileInputStream(firstFile);
            byte[] firstBuffer = new byte[firstFileInputStream.available()];
            int firstCount = firstFileInputStream.read(firstBuffer);

            FileInputStream secondFileInputStream = new FileInputStream(secondFile);
            byte[] secondBuffer = new byte[secondFileInputStream.available()];
            int secondCount = secondFileInputStream.read(secondBuffer);

            FileOutputStream outputStream = new FileOutputStream(firstFile);
            outputStream.write(secondBuffer, 0, secondCount);
            outputStream.write(firstBuffer, 0, firstCount);
            outputStream.close();

            firstFileInputStream.close();
            secondFileInputStream.close();

        } catch (Exception e) {

        }
    }
}
