package com.javarush.task.task18.task1809;

/* 
Реверс файла
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
            String outputFile = reader.readLine();
            reader.close();

            FileInputStream inputStream = new FileInputStream(inputFile);
            FileOutputStream outputStream = new FileOutputStream(outputFile);

            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            for (int i=buffer.length-1; i>=0; i--) {
                outputStream.write(buffer[i]);
            }

            inputStream.close();
            outputStream.close();
        } catch (Exception e) {

        }
    }
}
