package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String fileName = reader.readLine();
            reader.close();

            FileReader fileReader = new FileReader(fileName);

            StringBuilder builder = new StringBuilder();

            while (fileReader.ready()) {
                int b = fileReader.read();
                builder.append((char) b);
            }
            fileReader.close();

            String text = builder.toString().replaceAll("[\n\r\t]","");

            Stack<Integer> integerStack = new Stack<>();

            Matcher m = Pattern.compile("<(/?)" + args[0] + ".*?>").matcher(text);
            TreeMap<Integer,Integer> map = new TreeMap<>();

            while (m.find()){
                if (text.charAt(m.start()+1)== '/'){
                    map.put(integerStack.pop(),m.end());
                }else {
                    integerStack.push(m.start());
                }
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println(text.substring(entry.getKey(), entry.getValue()));
            }

        } catch (Exception e) {

        }
    }
}
