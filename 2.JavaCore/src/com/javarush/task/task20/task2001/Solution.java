package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File file = File.createTempFile("/home/mrslow/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task20/task2001/test.txt", null);
            OutputStream outputStream = new FileOutputStream(file);
            InputStream inputStream = new FileInputStream(file);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            String isNamePresent = name != null ? name : "Anonim";
            ArrayList<String> isAssetsPresent = new ArrayList<>();
            if (assets != null) {
                for (Asset asset : assets) {
                    isAssetsPresent.add(asset.getName() + ":" + asset.getPrice());
                }
            }
            String toWrite = String.join("\t", isNamePresent, String.join("|", isAssetsPresent));
            outputStream.write(toWrite.getBytes());
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            String[] items = new String(buffer).split("\\t");
            name = (items[0].equals("Anonim")) ? null : items[0];
            if (items.length > 1) {
                String[] assetStr = items[1].split("\\|");
                for (String asset : assetStr) {
                    String[] assetItems = asset.split(":");
                    assets.add(new Asset(assetItems[0], Double.parseDouble(assetItems[1])));
                }
            }
        }
    }
}
