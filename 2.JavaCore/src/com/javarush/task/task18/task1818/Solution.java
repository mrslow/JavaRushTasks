package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String outputFile = reader.readLine();
            String firstInputFile = reader.readLine();
            String secondInputFile = reader.readLine();
            reader.close();

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            FileInputStream firstInputStream = new FileInputStream(firstInputFile);
            FileInputStream secondInputStream = new FileInputStream(secondInputFile);

            while (firstInputStream.available() > 0) {
                outputStream.write(firstInputStream.read());
            }
            firstInputStream.close();

            while (secondInputStream.available() > 0) {
                outputStream.write(secondInputStream.read());
            }
            secondInputStream.close();

            outputStream.close();

        } catch (Exception e) {

        }
    }
}
