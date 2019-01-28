package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }

    public void write(int i) throws IOException {
        fileWriter.write(i);
        System.out.print(i);
    }

    public void write(char[] chars, int i, int i1) throws IOException {
        fileWriter.write(chars, i, i1);
        System.out.print(new String(chars, i, i1));
    }

    public void write(String s, int i, int i1) throws IOException {
        fileWriter.write(s, i, i1);
        System.out.print(s.substring(i, i + i1));
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public String getEncoding() {
        return fileWriter.getEncoding();
    }

    public void flush() throws IOException {
        fileWriter.flush();
    }

    public void write(char[] chars) throws IOException {
        fileWriter.write(chars);
        System.out.print(chars);
    }

    public void write(String s) throws IOException {
        fileWriter.write(s);
        System.out.print(s);
    }

    public static void main(String[] args) {

    }

}
