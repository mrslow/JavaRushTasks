package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            PrintStream consoleStream = System.out;

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            PrintStream stream = new PrintStream(outputStream);
            System.setOut(stream);

            testString.printSomething();

            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(outputStream.toByteArray());
            fileOutputStream.close();
            String text = outputStream.toString();

            System.setOut(consoleStream);

            System.out.println(text);
        } catch (IOException e) {

        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

