package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try {
            Map<String, Double> entries = new TreeMap<>();
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                String name = line.split(" ")[0];
                double money = Double.parseDouble(line.split(" ")[1]);
                if (entries.containsKey(name)) {
                    entries.put(name, entries.get(name) + money);
                } else {
                    entries.put(name, money);
                }
            }

            for (Map.Entry<String, Double> entry : entries.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            reader.close();
            fileReader.close();
        } catch (Exception e) {

        }
    }
}
