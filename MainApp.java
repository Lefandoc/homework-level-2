package ru.gb.homework3;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("max");
        list.add("min");
        list.add("max");
        list.add("min");
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("four");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("seven");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        list.add("ten");

        Set<String> set = new HashSet<String>(list);
        System.out.println("Уникальные значения: " + set);

        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            Integer counter = map.get(s);
            map.put(s, counter == null ? 1 : counter + 1);
        }

        System.out.println("Количество повторений каждого значения: " + map);
    }
}
