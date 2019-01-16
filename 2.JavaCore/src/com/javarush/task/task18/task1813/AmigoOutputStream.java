package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    //public static String fileName = "C:/tmp/result.txt";
    public static String fileName = "/home/mrslow/IdeaProjects/JavaRushTasks/2.JavaCore/src/com/javarush/task/task18/task1813/data.txt";
    private FileOutputStream original;

    public AmigoOutputStream(FileOutputStream outputStream) throws IOException {
        super(outputStream.getFD());
        this.original = outputStream;
    }

    @Override
    public void write(int i) throws IOException {
        original.write(i);
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        original.write(bytes);
    }

    @Override
    public void write(byte[] bytes, int i, int i1) throws IOException {
        original.write(bytes, i, i1);
    }

    @Override
    public void close() throws IOException {
        original.flush();
        original.write("JavaRush © All rights reserved.".getBytes());
        original.close();
    }

    @Override
    public void flush() throws IOException {
        original.flush();
    }

    public static void main(String[] args) throws IOException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
