package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split(" ");
                ArrayList<String> nameBuilder = new ArrayList<>(1);
                String dateString = "";
                for (int i=0; i<words.length-3; i++) {
                    nameBuilder.add(words[i]);
                }
                for (int i=words.length-3; i<words.length; i++) {
                    dateString += words[i] + " ";
                }
                String name = String.join(" ", nameBuilder);
                SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
                Date birthDate = formatter.parse(dateString);
                System.out.println(name + " : " + birthDate);
                PEOPLE.add(new Person(name, birthDate));
            }
            reader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
