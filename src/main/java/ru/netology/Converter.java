package ru.netology;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Converter {

    public static <T> String listToJson(List<T> employees) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type listType = new TypeToken<List<T>>() {
        }.getType();
        return gson.toJson(employees, listType);
    }

    public static Employee convertFromMapToObject(Map<String, Object> map) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String jsonString = gson.toJson(map);
        return gson.fromJson(jsonString, Employee.class);
    }

    public static List<Employee> jsonToList(String json) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        List<Employee> employees = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            JSONArray staff = (JSONArray) parser.parse(json);
            for (Object employee : staff) {
                employees.add(gson.fromJson(employee.toString(), Employee.class));
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }
}
