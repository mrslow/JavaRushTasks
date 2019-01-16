package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String fileName = reader.readLine();
                if (fileName.equals("exit")) {
                    break;
                }
                new ReadThread(fileName).start();
            }
        } catch (Exception e) {

        }

        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try {
                HashMap<Integer, Integer> countersMap = new HashMap<>();
                FileInputStream fileStream = new FileInputStream(fileName);
                while (fileStream.available() > 0) {
                    int letter = fileStream.read();
                    if (!countersMap.containsKey(letter)) {
                        countersMap.put(letter, 1);
                    } else {
                        countersMap.put(letter, countersMap.get(letter) + 1);
                    }
                }
                int maxValueKey = 0;
                int maxValue = -1;
                for (Map.Entry<Integer, Integer> entry : countersMap.entrySet()) {
                    if (entry.getValue() > maxValue) {
                        maxValue = entry.getValue();
                        maxValueKey = entry.getKey();
                    }
                }

                synchronized (resultMap) {
                    resultMap.put(fileName, maxValueKey);
                }
                fileStream.close();
            } catch (IOException e) {

            }
        }


    }
}
