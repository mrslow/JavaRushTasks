package com.javarush.task.task19.task1914;

/* 
Решаем пример
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

        String result = outputStream.toString().trim();
        String[] equation = result.split(" ");
        int a = Integer.parseInt(equation[0]);
        int b = Integer.parseInt(equation[2]);
        switch (equation[1]) {
            case "-":
                result +=  " " + (a - b);
                break;
            case "+":
                result += " " + (a + b);
                break;
            case "*":
                result += " " + (a * b);
                break;
        }

        System.setOut(consoleStream);

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

