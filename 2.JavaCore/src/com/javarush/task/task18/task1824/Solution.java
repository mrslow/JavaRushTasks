package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                String filename;
                filename = reader.readLine();
                try {
                    FileInputStream fileStream = new FileInputStream(filename);
                    fileStream.close();
                } catch (FileNotFoundException e) {
                    System.out.println(filename);
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {

        }
    }
}
