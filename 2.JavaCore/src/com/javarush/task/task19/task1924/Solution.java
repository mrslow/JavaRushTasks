package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(0,"ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            FileReader fileReader = new FileReader(consoleReader.readLine());
            consoleReader.close();
            StringBuilder fileContent = new StringBuilder();

            while (fileReader.ready()) {
                fileContent.append((char)fileReader.read());
            }
            fileReader.close();

            String[] inputWords = fileContent.toString().split(" ");
            String[] outputWords = new String[inputWords.length];
            for (int i=0; i<inputWords.length; i++) {
                try {
                    int number = Integer.parseInt(inputWords[i]);
                    outputWords[i] = map.getOrDefault(number, inputWords[i]);
                } catch (NumberFormatException e) {
                    outputWords[i] = inputWords[i];
                }
            }

            System.out.println(String.join(" ", outputWords));
        } catch (Exception e) {

        }
    }
}
