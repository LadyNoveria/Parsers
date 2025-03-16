package ru.netology;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterTest {

    private static final List<Employee> STAFF = List.of(
            new Employee(1, "John", "Smith", "USA", 25),
            new Employee(2, "Inav", "Petrov", "RU", 23));

    private static final String JSON =
            "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25}," +
                    "{\"id\":2,\"firstName\":\"Inav\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";

    private static final Map<String, Object> VALUES_MAP = Map.of(
            "id", 1,
            "firstName", "John",
            "lastName", "Smith",
            "country", "USA",
            "age", 25);

/// ВАРИАНТ ТЕСТОВ ДЛЯ ЗАДАЧИ 1
//    @Test
//    public void listToJsonTest() {
//        String actual = Converter.listToJson(STAFF);
//        assertEquals(JSON, actual);
//    }
//
//    @Test
//    public void convertFromMapToObjectTest() {
//        Employee expected = STAFF.get(0);
//        Employee actual = Converter.convertFromMapToObject(VALUES_MAP);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void jsonToListTest() {
//        List<Employee> actual = Converter.jsonToList(JSON);
//        assertEquals(STAFF, actual);
//    }

    /// ВАРИАНТ ТЕСТОВ ДЛЯ ЗАДАЧИ 2

    @Test
    public void convertFromMapToObjectTest_1() {
        var actual = Converter.convertFromMapToObject(VALUES_MAP);
        assertThat(actual, instanceOf(Employee.class));
        assertThat(STAFF.get(0), is(actual));
    }

    @Test
    public void listToJsonTest() {
        String actual = Converter.listToJson(STAFF);
        assertThat(JSON, is(actual));
    }

    @Test
    public void convertFromMapToObjectTest_2() {
        var actual = Converter.convertFromMapToObject(VALUES_MAP);
        assertThat(actual, instanceOf(Employee.class));
    }

    @Test
    public void jsonToListTest_1() {
        List<Employee> actual = Converter.jsonToList(JSON);
        assertEquals(STAFF, actual);
    }

    @Test
    public void jsonToListTest_2() {
        List<Employee> actual = Converter.jsonToList(JSON);
        assertThat(actual, hasSize(2));
    }
}
