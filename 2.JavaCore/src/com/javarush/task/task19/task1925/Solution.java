package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        try {
            List<String> list = new ArrayList<>();
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.length() > 6) {
                        list.add(word);
                    }
                }
            }
            reader.close();
            fileReader.close();

            FileWriter fileWriter = new FileWriter(args[1]);
            fileWriter.write(String.join(",", list));
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
