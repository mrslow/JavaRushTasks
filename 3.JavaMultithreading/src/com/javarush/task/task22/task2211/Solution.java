package com.javarush.task.task22.task2211;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);
        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);

        Charset utf8 = StandardCharsets.UTF_8;
        Charset windows1251 = Charset.forName("Windows-1251");

        fileOutputStream.write(new String(buffer, windows1251).getBytes(utf8));

        fileInputStream.close();
        fileOutputStream.close();
    }
}
