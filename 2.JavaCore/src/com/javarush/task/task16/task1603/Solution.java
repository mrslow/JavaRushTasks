package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        Thread t1 = new Thread(new SpecialThread());
        Thread t2 = new Thread(new SpecialThread());
        Thread t3 = new Thread(new SpecialThread());
        Thread t4 = new Thread(new SpecialThread());
        Thread t5 = new Thread(new SpecialThread());

        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
