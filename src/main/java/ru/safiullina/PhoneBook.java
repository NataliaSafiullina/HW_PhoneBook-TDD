package ru.safiullina;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    Map<String, String> phoneBook = new HashMap<>();

    public int add(String name, String phoneNumber) {
        phoneBook.put(name, phoneNumber);
        return phoneBook.size();
    }
}
