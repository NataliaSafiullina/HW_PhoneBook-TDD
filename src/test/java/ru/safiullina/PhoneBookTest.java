package ru.safiullina;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    @Test
    public void testAdd() {
        // Создадим набор тестовых данных
        Map<String, String> testData = new HashMap<>();
        testData.put("Adam Yang", "1234567");
        testData.put("Zombie Rob", "198765");
        int trueResult = testData.size();

        // Создадим объект класса
        PhoneBook phoneBook = new PhoneBook();
        int result = 0;

        // Добавляем тестовые данные
        for (Map.Entry<String, String> entity : testData.entrySet()) {
            result = phoneBook.add(entity.getKey(), entity.getValue());
        }

        // Добавим одинаковое имя
        phoneBook.add(testData.keySet().iterator().next(), testData.values().iterator().next());

        assertEquals(result, trueResult,
                "Неверное количество записей, получено " + result + ", должно быть " + trueResult);

    }

}