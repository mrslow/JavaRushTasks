package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/


import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        ArrayList<String> lines = new ArrayList<>();

        while (fileReader.ready()) {
            String line = fileReader.readLine().replaceAll("\\p{Punct}", "");
            lines.add(line);
        }
        fileReader.close();

        for (String line : lines) {
            fileWriter.write(line);
        }
        fileWriter.close();
    }
}
