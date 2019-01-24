package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            FileReader fileReader = new FileReader(consoleReader.readLine());
            consoleReader.close();
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                StringBuffer buf = new StringBuffer(line);
                System.out.println(buf.reverse());
            }
            reader.close();
            fileReader.close();

        } catch (Exception e) {

        }
    }
}
