package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = reader.readLine();
            if (line.equals("exit")) {
                break;
            }

            try {
                if (line.contains(".")) {
                    Double doubleNum = Double.parseDouble(line);
                    print(doubleNum);
                } else {
                    Integer intNum = Integer.parseInt(line);
                    if (intNum <= 0 || intNum >= 128) {
                        print(intNum);
                    } else {
                        short shortNum = Short.parseShort(line);
                        if (0 < shortNum && shortNum < 128) {
                            print(shortNum);
                        }
                    }
                }
            } catch (NumberFormatException e) {
                print(line);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
