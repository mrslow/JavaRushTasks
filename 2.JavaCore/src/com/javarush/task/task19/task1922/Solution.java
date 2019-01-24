package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            FileReader fileReader = new FileReader(consoleReader.readLine());
            consoleReader.close();
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                for (String word : words) {
                    for (String string : line.split(" ")) {
                        if (string.equals(word)) {
                            counter++;
                        }
                    }
                }
                if (counter == 2) {
                    System.out.println(line);
                }
                counter = 0;
            }
            reader.close();
            fileReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
