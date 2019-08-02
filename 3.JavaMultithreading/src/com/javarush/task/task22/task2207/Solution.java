package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(consoleReader.readLine());
        consoleReader.close();
        String line;
        BufferedReader reader = new BufferedReader(fileReader);
        StringBuilder builder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append(" ");
        }
        reader.close();
        String[] words = builder.toString().split(" ");
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<words.length; i++) {
            if (set.contains(i)) continue;
            for (int j = i + 1; j < words.length; j++) {
                String x = new StringBuilder(words[j]).reverse().toString();
                if (x.equals(words[i])) {
                    Pair pair = new Pair();
                    pair.first = x;
                    pair.second = words[j];
                    result.add(pair);
                    set.add(j);
                    break;
                }
            }

        }

    }

    public static class Pair {
        String first;
        String second;

        public Pair() {}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
