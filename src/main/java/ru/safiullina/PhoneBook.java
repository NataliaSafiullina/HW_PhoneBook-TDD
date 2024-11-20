package ru.safiullina;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    Map<String, String> phoneBook = new HashMap<>();

    public int add(String name, String phoneNumber) {
        phoneBook.put(name, phoneNumber);
        return phoneBook.size();
    }

    public String findByNumber(String phoneNumber) {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getValue().equals(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public String findByName(String name) {
        return phoneBook.get(name);
    }

    public List<String> printAllNames() {
        return null;
    }
}
