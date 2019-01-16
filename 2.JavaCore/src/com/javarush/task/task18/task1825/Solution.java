package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> partNames = getPartsName();
        sort(partNames);

        FileOutputStream outputStream = new FileOutputStream(partNames.get(0).split(".part")[0]);

        for (String partName : partNames) {
            FileInputStream inputStream = new FileInputStream(partName);
            if (inputStream.available() > 0) {
                byte[] buffer = new byte[1024];
                int count = inputStream.read(buffer);
                outputStream.write(buffer, 0, count);
            }
            inputStream.close();
        }
        outputStream.close();
    }

    public static ArrayList<String> getPartsName() throws IOException {
        ArrayList<String> partNames = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileName = reader.readLine();
            if (fileName.equals("end")) {
                break;
            }
            partNames.add(fileName);
        }
        return partNames;
    }

    public static void sort(ArrayList<String> partNames) {
        int n = partNames.size();
        String temp;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                int currElem = Integer.parseInt(partNames.get(j).split("part")[1]);
                int nextElem = Integer.parseInt(partNames.get(j + 1).split("part")[1]);
                if (currElem > nextElem) {
                    temp = partNames.get(j);
                    partNames.set(j, partNames.get(j + 1));
                    partNames.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
    }
}
