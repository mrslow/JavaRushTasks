package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                for (int i=1; i<args.length; i=i+3) {
                    String name = args[i];
                    String sex = args[i+1];
                    String bd = args[i+2];
                    int id = createPerson(name, sex, bd);
                    System.out.println(id);
                }
                break;
            case "-u":
                for (int i=1; i<args.length; i=i+4) {
                    int id = Integer.parseInt(args[i]);
                    if (id < allPeople.size()) {
                        String name = args[i+1];
                        String sex = args[i+2];
                        String bd = args[i+3];
                        updatePerson(id, name, sex, bd);
                    } else {
                        System.out.println("No person with id=" + id + ". Nothing to update");
                    }
                }
                break;
            case "-d":
                for (int i=1; i<args.length; i++) {
                    int id = Integer.parseInt(args[i]);
                    if (id < allPeople.size()) {
                        deletePerson(id);
                    } else {
                        System.out.println("No person with id=" + id + ". Nothing to delete");
                    }
                }
                break;
            case "-i":
                for (int i=1; i<args.length; i++) {
                    int id = Integer.parseInt(args[i]);
                    if (id < allPeople.size()) {
                        System.out.println(getPerson(id));
                    } else {
                        System.out.println("No person with id=" + id + ". Nothing to view");
                    }
                }
                break;
        }
    }

    private static int createPerson(String name, String sex, String bd) {
        Date birthDate;
        try {
            String pattern = "dd/MM/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.ENGLISH);
            birthDate = simpleDateFormat.parse(bd);
        } catch (ParseException e) {
            birthDate = new Date();
        }
        Person person;
        if (sex.equals("м")) {
            person = Person.createMale(name, birthDate);
        } else {
            person = Person.createFemale(name, birthDate);
        }

        synchronized (allPeople) {
            allPeople.add(person);
        }
        return allPeople.indexOf(person);
    }

    private static void updatePerson(int id, String name, String s, String bd) {
        Date birthDate;
        try {
            String pattern = "dd/MM/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.ENGLISH);
            birthDate = simpleDateFormat.parse(bd);
        } catch (ParseException e) {
            birthDate = new Date();
        }

        Sex sex = null;
        if (s.equals("м")) {
            sex = Sex.MALE;
        } else if (s.equals("ж")) {
            sex = Sex.FEMALE;
        }
        synchronized (allPeople) {
            Person person = allPeople.get(id);
            person.setName(name);
            person.setSex(sex);
            person.setBirthDate(birthDate);
        }
    }

    private static void deletePerson(int id) {
        synchronized (allPeople) {
            Person person = allPeople.get(id);
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }
    }

    private static String getPerson(int id) {
        String info = "";
        Person person = allPeople.get(id);

        info += person.getName() + " ";

        if (person.getSex() == Sex.MALE) {
            info += "м ";
        } else if (person.getSex() == Sex.FEMALE) {
            info += "ж ";
        } else {
            info += null + " ";
        }

        String pattern = "dd-MMM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.ENGLISH);
        if (person.getBirthDate() != null) {
            info += simpleDateFormat.format(person.getBirthDate());
        } else {
            info += null;
        }

        return info;
    }
}
