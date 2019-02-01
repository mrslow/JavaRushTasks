package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.javarush.task.task20.task2025.ArmstrongNumbersMultiSetLongOpt.generate;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        List<Long> list1 = new ArrayList<>();
        List<Long> list2 = generate(20);
        for(Long l : list2)
            if (l < N) list1.add(l);
        long[] mas = new long[list1.size()];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = list1.get(i);
        }
        return mas;
    }


    public static void main(String[] args) {
        long memoryStart = Runtime.getRuntime().freeMemory();
        Long t0 = System.currentTimeMillis();
        long[] result = getNumbers(Long.MAX_VALUE);
        System.out.println(Arrays.toString(result));
        long memoryEnd = Runtime.getRuntime().maxMemory();
        long memoTaken = memoryStart - memoryEnd;
        System.out.println(memoTaken);
        Long t1 = System.currentTimeMillis();
        System.out.println("Time need to create the arrray = " + (t1 - t0));
        System.out.println("Used Memory in JVM: " + (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()));
    }
}
