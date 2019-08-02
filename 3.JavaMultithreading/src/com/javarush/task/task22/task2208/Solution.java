package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age",null);
        String query = getQuery(map);
        System.out.println(query);

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        String prefix = "";
        if (params == null || params.isEmpty())
            return "";

        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getKey() == null || pair.getValue() == null)
                continue;

            result.append(prefix);
            result.append(pair.getKey());
            result.append(" = ");
            result.append("'");
            result.append(pair.getValue());
            result.append("'");
            prefix = " and ";
        }

        return result.toString();
    }
}
