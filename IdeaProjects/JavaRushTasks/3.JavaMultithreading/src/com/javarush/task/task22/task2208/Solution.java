package com.javarush.task.task22.task2208;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        //{name=Ivanov, country=Ukraine, city=Kiev, age=null}
        //name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", "null");

        System.out.println(getQuery(map));

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder s = new StringBuilder();

        for (Map.Entry<String, String> param:params.entrySet()) {
            if(param.getValue() != null) {
                s.append(param.getKey() + " = '" + param.getValue() + "' and ");
            }
        }
        if (s.length() != 0) s.delete(s.length()-5, s.length());
        return s.toString();
    }
}
