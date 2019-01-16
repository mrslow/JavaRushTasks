package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<>();
    static {
        String line;

        try {

            BufferedReader bufferreader = new BufferedReader(new FileReader(Statics.FILE_NAME));

            while ((line = bufferreader.readLine()) != null) {
                lines.add(line);
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println(lines);
    }
}
