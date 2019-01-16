package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            File file = new File(fileName);
            FileInputStream fileReader = new FileInputStream(fileName);
            BufferedReader fileStream = new BufferedReader(new InputStreamReader(fileReader));

            String line;
            ArrayList<Integer> array = new ArrayList<>();
            while((line = fileStream.readLine()) != null) {
                array.add(Integer.parseInt(line));
            }
            fileStream.close();

            for (int out = array.size() - 1; out >= 1; out--){
                for (int in = 0; in < out; in++){
                    int first = array.get(in);
                    int second = array.get(in + 1);
                    if(first > second) {
                        int dummy = first;
                        array.set(in, second);
                        array.set(in+1, dummy);
                    }
                }
            }

            for (int number:array) {
                if (number % 2 == 0) {
                    System.out.println(number);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}