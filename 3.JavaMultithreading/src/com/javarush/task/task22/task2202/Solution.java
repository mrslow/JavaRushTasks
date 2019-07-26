package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null || string.isEmpty()) {
            throw new TooShortStringException();
        };

        String[] parts = string.split(" ");
        if (parts.length < 5) {
            throw new TooShortStringException();
        }

        StringBuilder builder = new StringBuilder();
        for (int i=1; i<5; i++) {
            builder.append(parts[i]);
            if (i<4) builder.append(" ");
        }

        return builder.toString();

    }

    public static class TooShortStringException extends RuntimeException { }
}
