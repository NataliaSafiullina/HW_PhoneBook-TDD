package ru.safiullina;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    // Создадим набор тестовых данных
    public static Map<String, String> testData = new HashMap<>();

    // Создадим объект класса
    public PhoneBook phoneBook = new PhoneBook();

    // Создадим поток аргументов
    public static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("Adam Yang", "1234567"),
                Arguments.of("Zombie Rob", "198765")
        );
    }

    @BeforeAll
    static void fillMap(){
        testData.put("Adam Yang", "1234567");
        testData.put("Zombie Rob", "198765");
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

        assertEquals(result, trueResult,
                "Неверное количество записей, получено " + result + ", должно быть " + trueResult);

    }

    @Test
    public void testFindByNumber(){

        // Запишем данные
        for (Map.Entry<String, String> entity : testData.entrySet()) {
            phoneBook.add(entity.getKey(), entity.getValue());
        }

        // Проверим что вернёт метод
        for (Map.Entry<String, String> entity : testData.entrySet()) {
            assertEquals(phoneBook.findByNumber(entity.getValue()), entity.getKey(),
                    "Не получили имя по номеру телефону");
        }
    }


}