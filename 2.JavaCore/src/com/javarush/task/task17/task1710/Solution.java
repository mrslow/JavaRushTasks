package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        String arg = args[0];
        if (arg.equals("-c")) {
            String name = args[1];
            String sex = args[2];
            String bd = args[3];
            int id = createPerson(name, sex, bd);
            System.out.println(id);
        } else if (arg.equals("-u")) {
            int id = Integer.parseInt(args[1]);
            if (id < allPeople.size()) {
                String name = args[2];
                String sex = args[3];
                String bd = args[4];
                updatePerson(id, name, sex, bd);
                System.out.println(getPerson(id));
            } else {
                System.out.println("No person with id=" + id + ". Nothing to update");
            }
        } else if (arg.equals("-d")) {
            int id = Integer.parseInt(args[1]);
            if (id < allPeople.size()) {
                deletePerson(id);
                System.out.println(getPerson(id));
            } else {
                System.out.println("No person with id=" + id + ". Nothing to delete");
            }
        } else if (arg.equals("-i")) {
            int id = Integer.parseInt(args[1]);
            if (id < allPeople.size()) {
                System.out.println(getPerson(id));
            } else {
                System.out.println("No person with id=" + id + ". Nothing to view");
            }
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
        if (sex.equals("м")) {
            allPeople.add(Person.createMale(name, birthDate));
        } else {
            allPeople.add(Person.createFemale(name, birthDate));
        }
        return allPeople.size() - 1;
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

        Person person = allPeople.get(id);
        person.setName(name);
        person.setSex(sex);
        person.setBirthDate(birthDate);
        allPeople.set(id, person);
    }

    private static void deletePerson(int id) {
        Person person = allPeople.get(id);
        person.setName(null);
        person.setSex(null);
        person.setBirthDate(null);
        allPeople.set(id, person);
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
