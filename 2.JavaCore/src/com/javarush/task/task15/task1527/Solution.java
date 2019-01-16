package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String objValue = null;
            String url = reader.readLine();
            String paramsString = url.substring(url.indexOf("?") + 1);
            String[] params = paramsString.split("&");
            String[] result = new String[params.length];
            for (int i=0; i<params.length; i++) {
                String[] pair = params[i].split("=");
                result[i] = pair[0];
                if (pair[0].equals("obj")) {
                    objValue = pair[1];
                }
            }
            reader.close();
            System.out.println(String.join(" ", result));
            if (objValue != null) {
                try {
                    alert(Double.parseDouble(objValue));
                } catch (NumberFormatException e) {
                    alert(objValue);
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
