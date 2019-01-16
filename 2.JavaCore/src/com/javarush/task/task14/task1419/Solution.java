package com.javarush.task.task14.task1419;

import javax.management.BadAttributeValueExpException;
import javax.xml.ws.http.HTTPException;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.security.KeyException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.zip.DataFormatException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        exceptions.add(new IllegalStateException());
        exceptions.add(new SecurityException());
        exceptions.add(new ClassCastException());
        exceptions.add(new NegativeArraySizeException());
        exceptions.add(new NullPointerException());
        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new NoSuchFieldException());
        exceptions.add(new NoSuchMethodException());
        exceptions.add(new NumberFormatException());


    }
}
