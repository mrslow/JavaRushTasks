package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename = reader.readLine();
            reader.close();

            ArrayList<String> rows = getRows(filename);

            switch (args[0]) {
                case "-u":
                    updateRow(filename, rows, args);
                    break;
                case "-d":
                    deleteRow(filename, rows, args[1]);
                    break;
                default:
                    System.out.println("Unknown argument: " + args[0]);
                    break;
            }
        }
    }

    public static ArrayList<String> getRows(String filename) throws IOException {
        ArrayList<String> rows = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = br.readLine()) != null)   {
            rows.add(line);
        }
        inputStream.close();
        return rows;
    }

    public static void updateRow(String filename, ArrayList<String> rows, String[]args) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(filename);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        for (String row : rows) {
            if (row.substring(0,8).trim().equals(args[1])) {
                row = prepareRow(args);
            }
            writer.write(row);
            writer.newLine();
        }
        writer.close();
        outputStream.close();
    }

    public static void deleteRow(String filename, ArrayList<String> rows, String id) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(filename);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        for (String row : rows) {
            if (!row.substring(0,8).trim().equals(id)) {
                writer.write(row);
                writer.newLine();
            }
        }
        writer.close();
        outputStream.close();
    }

    public static String prepareRow(String[] args) {
        String[] rowArgs = new String[4];
        rowArgs[0] = (args[1] + "        ").substring(0, 8);
        rowArgs[1] = (args[2] + "                              ").substring(0, 30);
        rowArgs[2] = (args[3] + "        ").substring(0, 8);
        rowArgs[3] = (args[4] + "    ").substring(0, 4);

        return String.join("", rowArgs);
    }
}
