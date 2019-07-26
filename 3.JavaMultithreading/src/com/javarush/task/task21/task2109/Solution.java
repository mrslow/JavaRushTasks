package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected A clone() throws CloneNotSupportedException {
            return new A(this.i, this.j);
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            int i = getI();
            int j = getJ();
            String name = getName();
            return new C(i, j, name);
        }


    }

    public static void main(String[] args) {
        A a = new A(5, 7);
        A aClone = null;
        try {
            aClone = a.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("      A: " + a);
        System.out.println("A clone: " + aClone);
        B b = new B(1, 2, "NAME");
        B bClone = null;
        try {
            bClone = b.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("      B: " + b);
        System.out.println("B clone: " + bClone);
        C c = new C(5, 7, "NAME");
        C cClone = null;
        try {
            cClone = c.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("      C: " + c);
        System.out.println("C clone: " + cClone);
    }
}
