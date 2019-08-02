package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> tokensList = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            tokensList.add(token);
        }
        return tokensList.toArray(new String[tokensList.size()]);
    }
}
