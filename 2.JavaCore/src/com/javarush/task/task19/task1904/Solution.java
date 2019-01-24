package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] line = fileScanner.nextLine().split(" ", 4);
            SimpleDateFormat ft = new SimpleDateFormat("dd MM yyyy");
            Date birthDate = null;
            try {
                birthDate = ft.parse(line[3]);
            } catch (ParseException e) {

            }
            return new Person(line[1], line[2], line[0], birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }


    }
}
