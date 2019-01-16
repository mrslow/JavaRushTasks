package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            String id = args[0];

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String filename = consoleReader.readLine();
            consoleReader.close();

            FileInputStream inputStream = new FileInputStream(filename);
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = fileReader.readLine();
            while(line != null){
                String expectedId = line.split(" ")[0];
                if (expectedId.equals(id)) {
                    System.out.println(line);
                    break;
                }
                line = fileReader.readLine();
            }

            inputStream.close();
            fileReader.close();
        } catch (IOException e) {

        }
    }
}
