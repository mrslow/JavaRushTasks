package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        boolean flag = false;
        int flagShows = 0;

        for(int i = 0; i < a.length; i++) {
            for(int i1 = 0; i1 < a[i].length; i1++) {

                if(a[i][i1] == 1){
                    flag = true;
                    for(int j = i; j < a.length; j++) {
                        if(a[j][i1] == 1){
                            a[j][i1] = 0;
                        }else if(a[j][i1] == 0){
                            break;
                        }
                    }
                }else {
                    flag = false;
                }

                if(flag && flagShows == 0){
                    ++count;
                    flagShows = 1;
                }else if(!flag && flagShows == 1){
                    flagShows = 0;
                }
            }
        }



        return count;
    }
}
