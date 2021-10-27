package ru.gb.homework3;

import java.util.*;

public class PhonebookApp {
    private static final HashMap<String, ArrayList<String>> map = new HashMap<>();


    public void add(String lastname, String phoneNumber) {
        ArrayList<String> phoneNumbers = map.getOrDefault(lastname, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        map.put(lastname, phoneNumbers);
    }

    public void get(String lastname) {
        System.out.println("Lastname: " + lastname + ", phone number: " + map.get(lastname));

    }

    public static void main(String[] args) {
        PhonebookApp book = new PhonebookApp();

        book.add("Smith", "84958861192");
        book.add("Smith", "88005553535");
        book.add("Smith", "89776258374");
        book.add("Connor", "89556235894");
        book.add("Connor", "89754571998");
        book.add("Allen", "89252064175");
        book.add("Allen", "84994146573");
        book.add("Banner", "89163575851");

        book.get("Smith");
        book.get("Connor");
        book.get("Allen");
        book.get("Banner");
    }
}
