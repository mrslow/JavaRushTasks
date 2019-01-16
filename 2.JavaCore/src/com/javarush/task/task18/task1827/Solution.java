package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename = reader.readLine();
            reader.close();

            int maxId = getMaxId(filename);
            String row = prepareRow(args, maxId);

            FileOutputStream outputStream = new FileOutputStream(filename, true);
            outputStream.write(row.getBytes());

            outputStream.close();
        }
    }

    public static int getMaxId(String filename) throws IOException {
        FileInputStream inputStream = new FileInputStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        int maxId = 0;
        while ((line = br.readLine()) != null)   {
            int id = Integer.parseInt(line.substring(0, 8).trim());
            maxId = (id > maxId) ? id : maxId;
        }
        inputStream.close();

        return maxId + 1;
    }

    public static String prepareRow(String[] args, int id) {
        String[] rowArgs = new String[5];
        rowArgs[0] = "\n";
        rowArgs[1] = String.format("%-8d", id);
        rowArgs[2] = (args[1] + "                              ").substring(0, 30);
        rowArgs[3] = (args[2] + "        ").substring(0, 8);
        rowArgs[4] = (args[3] + "    ").substring(0, 4);

        return String.join("", rowArgs);
    }
}
