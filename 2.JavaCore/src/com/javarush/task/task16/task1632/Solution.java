package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {

    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
            }
        }
    }

    public static class  Thread2 extends Thread {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class Thread3 extends Thread {
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        @Override
        public void showWarning() {
            this.interrupt();
        }

        public void run() {
            while (!this.isInterrupted()) {
            }
        }
    }

    public static class Thread5 extends Thread {
        public void run() {
            List<Integer> list = new ArrayList<>();
            int sum = 0;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            try {
                while (!(line = reader.readLine()).equals("N")) {
                    list.add(Integer.parseInt(line));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int elem : list) {
                sum += elem;
            }
            System.out.println(sum);
        }
    }
}
