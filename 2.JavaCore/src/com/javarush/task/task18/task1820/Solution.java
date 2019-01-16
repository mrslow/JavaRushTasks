package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String firstFile = reader.readLine();
            String secondFile = reader.readLine();
            reader.close();

            FileOutputStream outputStream = new FileOutputStream(secondFile);
            FileInputStream inputStream = new FileInputStream(firstFile);
            BufferedReader inputFile = new BufferedReader(new InputStreamReader(inputStream));

            if (inputFile.ready()) {
                String line = inputFile.readLine();
                String[] elements = line.split(" ");
                String[] outputArray = new String[elements.length];
                for (int i=0; i<elements.length; i++) {
                    float f = Float.parseFloat(elements[i]);
                    outputArray[i] = "" + Math.round(f);
                }
                outputStream.write(String.join(" ", outputArray).getBytes());
            }
            inputFile.close();


            inputStream.close();
            outputStream.close();

        } catch (IOException e) {

        }
    }
}
