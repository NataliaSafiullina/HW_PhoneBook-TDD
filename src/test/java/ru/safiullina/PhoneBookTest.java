package ru.safiullina;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    // Создадим набор тестовых данных
    public static Map<String, String> testData = new HashMap<>();

    // Создадим объект класса
    public PhoneBook phoneBook = new PhoneBook();

    @BeforeAll
    static void fillMap(){
        testData.put("Zombie Rob", "1234567");
        testData.put("Adam Yang", "198765");
    }

    @Test
    public void testAdd() {

        int trueResult = testData.size();
        int result = 0;

        // Добавляем тестовые данные
        for (Map.Entry<String, String> entity : testData.entrySet()) {
            result = phoneBook.add(entity.getKey(), entity.getValue());
        }

        // Добавим одинаковое имя
        phoneBook.add(testData.keySet().iterator().next(), testData.values().iterator().next());

        assertEquals(trueResult, result,
                "Неверное количество записей, получено " + result + ", должно быть " + trueResult);

    }

    @Test
    public void testFindByNumber(){
        // Запишем данные
        addData();

        // Проверим что вернёт метод
        for (Map.Entry<String, String> entry : testData.entrySet()) {
            assertEquals(entry.getKey(),
                    phoneBook.findByNumber(entry.getValue()),
                    "Не получили имя по номеру телефону " + entry.getValue());
        }
    }

    @Test
    public void testFindByName(){
        // Запишем данные
        addData();

        // Проверим что вернёт метод
        for (Map.Entry<String, String> entry : testData.entrySet()) {
            assertEquals(entry.getValue(),
                    phoneBook.findByName(entry.getKey()),
                    "Не получили номер телефона по имени " + entry.getKey());
        }
    }

    @Test
    public void testPrintAllNames() {

        addData();

        // Сортируем наши данные
        List<String> trueNames = new ArrayList<>(testData.keySet());
        Collections.sort(trueNames);

        // Получаем сортировку из метода
        List<String> names = new ArrayList<>();
        names = phoneBook.printAllNames();

        assertTrue(names.equals(trueNames));

    }


    public void addData() {
        for (Map.Entry<String, String> entry : testData.entrySet()) {
            phoneBook.add(entry.getKey(), entry.getValue());
        }
    }
}