package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        try {
            HashMap<String, Double> entries = new HashMap<>();
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
            reader.close();
            fileReader.close();

            double maxValue = 0;
            for (Map.Entry<String, Double> entry : entries.entrySet()) {
                maxValue = (maxValue < entry.getValue()) ? entry.getValue() : maxValue;
            }

            SortedSet<String> names = new TreeSet<>();
            for (Map.Entry<String, Double> entry : entries.entrySet()) {
                if (entry.getValue() == maxValue) {
                    names.add(entry.getKey());
                }
            }

            System.out.println(String.join(" ", names));
        } catch (Exception e) {

        }
    }
}
