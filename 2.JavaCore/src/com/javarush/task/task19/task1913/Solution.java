package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String result = "";
        String numbers = "0123456789";
        byte[] symbols = outputStream.toByteArray();
        for (int i=0; i<symbols.length; i++) {
            char symbol = (char) symbols[i];
            if (numbers.contains(String.valueOf(symbol))) {
                result += symbol;
            }
        }
        System.setOut(consoleStream);

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
