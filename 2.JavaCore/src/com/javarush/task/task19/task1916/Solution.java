package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) {
        try {
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String line;
            FileReader fileReader = new FileReader(consoleReader.readLine());
            BufferedReader firstFileReader = new BufferedReader(fileReader);
            while ((line = firstFileReader.readLine()) != null) {
                list1.add(line);
            }
            firstFileReader.close();

            fileReader = new FileReader(consoleReader.readLine());
            BufferedReader secondFileReader = new BufferedReader(fileReader);
            while ((line = secondFileReader.readLine()) != null) {
                list2.add(line);
            }
            secondFileReader.close();
            consoleReader.close();

            while (true) {
                if (list1.size() == 0 & list2.size() > 0) {
                    lines.add(new LineItem(Type.ADDED, list2.get(0)));
                    break;
                }

                if (list2.size() == 0 & list1.size() >0) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                    break;
                }


                if (list1.get(0).equals(list2.get(0))) {
                    lines.add(new LineItem(Type.SAME, list1.get(0)));
                    list1.remove(0);
                    list2.remove(0);
                } else if (list1.get(0).equals(list2.get(1))) {
                    lines.add(new LineItem(Type.ADDED, list2.get(0)));
                    list2.remove(0);
                } else if (list1.get(1).equals((list2.get(0)))) {
                    lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                    list1.remove(0);
                }

            }


            for (LineItem elem : lines) {
                System.out.println(elem.type + " " + elem.line);
            }

        } catch (Exception e) {

        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
