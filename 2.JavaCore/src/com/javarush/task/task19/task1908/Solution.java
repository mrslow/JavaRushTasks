package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        ArrayList<String> numbers = new ArrayList<>();

        while (fileReader.ready()) {
            String[] words = fileReader.readLine().split(" ");
            for (String word : words) {
                try {
                    Integer.parseInt(word);
                    numbers.add(word);
                } catch (NumberFormatException e) {

                }
            }
        }
        fileReader.close();

        fileWriter.write(String.join(" ", numbers));
        fileWriter.close();
    }
}
