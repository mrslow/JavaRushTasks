package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        try {
            SortedSet<Integer> set = new TreeSet<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            FileInputStream inputStream = new FileInputStream(args[0]);
            while (inputStream.available() > 0) {
                int letter = inputStream.read();
                set.add(letter);
                if (!map.containsKey(letter)) {
                    map.put(letter, 1);
                } else {
                    map.put(letter, map.get(letter) + 1);
                }
            }
            for (int elem : set) {
                System.out.println((char) elem + " " + map.get(elem));
            }

            inputStream.close();

        } catch (IOException e ){

        }
    }
}
