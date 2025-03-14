package ru.netology;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //ЗАДАЧА 1
        Writer.writeToCSV("1,John,Smith,USA,25".split(",")); //запись объекта в CSV
        Writer.writeToCSV("2,Inav,Petrov,RU,23".split(",")); //запись объекта в CSV
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        List<Employee> employees_1 = Reader.parseCSV(columnMapping, fileName); //распарсить файл CSV в список объектов Employee
        String json_1 = Converter.listToJson(employees_1); //конвертировать объекты в JSON строку
        Writer.writeString(json_1, "new_data_1.json"); //записать JSON в файл

        //ЗАДАЧА 2
        Writer.createAndWriteToXNL(); //создание и запись XML файла
        List<Employee> employees_2 = Reader.parseXML(); //распарсить XML файл в список объектов
        String json_2 = Converter.listToJson(employees_2); //конвертировать объекты в JSON строку
        Writer.writeString(json_2, "new_data_2.json"); //записать JSON в файл

        //ЗАДАЧА 3
        String json = Reader.readString("new_data_2.json"); //чтение строки из файла .json
        List<Employee> employees_3 = Converter.jsonToList(json); //конвертировать строки в объекты
        employees_3.forEach(System.out::println);
    }
}