package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("/home/mrslow/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2002/test.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();

            User ivanov = new User();
            ivanov.setCountry(User.Country.RUSSIA);
            ivanov.setMale(true);
            ivanov.setBirthDate(new Date());
            ivanov.setFirstName("Ivan");
            ivanov.setLastName("Ivanov");
            javaRush.users.add(ivanov);

            User petrov = new User();
            petrov.setCountry(User.Country.UKRAINE);
            petrov.setMale(true);
            petrov.setBirthDate(new Date());
            petrov.setFirstName("Peter");
            petrov.setLastName("Peterson");
            javaRush.users.add(petrov);

            User sidorova = new User();
            sidorova.setCountry(User.Country.OTHER);
            sidorova.setMale(false);
            sidorova.setBirthDate(new Date());
            sidorova.setFirstName("Koza");
            sidorova.setLastName("Sidorova");
            javaRush.users.add(sidorova);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.users.equals(javaRush.users));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            String toWrite = "";
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            for (User user : users) {
                toWrite += (user.getFirstName() != null) ? user.getFirstName() : "null";
                toWrite += ";";
                toWrite += (user.getLastName() != null) ? user.getLastName() : "null";
                toWrite += ";";
                toWrite += (user.getBirthDate() != null) ? formatter.format(user.getBirthDate()) : "null";
                toWrite += ";";
                toWrite += user.isMale() ? "male" : "female";
                toWrite += ";";
                toWrite += (user.getCountry() != null) ? user.getCountry().getDisplayName() : "null";
                toWrite += "|";
            }
            outputStream.write(toWrite.getBytes());
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            String[] usersStrings = new String(buffer).split("\\|");
            if (!usersStrings[0].equals("")) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                for (String userString : usersStrings) {
                    User user = new User();
                    String[] userAttrs = userString.split(";");
                    user.setFirstName(!userAttrs[0].equals("null") ? userAttrs[0] : null);
                    user.setLastName(!userAttrs[1].equals("null") ? userAttrs[1] : null);
                    user.setBirthDate(!userAttrs[2].equals("null") ? formatter.parse(userAttrs[2]) : null);
                    user.setMale(userAttrs[3].equals("male"));
                    User.Country country;
                    switch (userAttrs[4]) {
                        case "Ukraine":
                            country = User.Country.UKRAINE;
                            break;
                        case "Russia":
                            country = User.Country.RUSSIA;
                            break;
                        default:
                            country = User.Country.OTHER;
                            break;
                    }
                    user.setCountry(country);
                    users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
