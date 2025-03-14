package ru.netology;

import com.opencsv.CSVWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public static void writeString(String json, String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToCSV(String[] array) {
        try (CSVWriter writer = new CSVWriter(new FileWriter("data.csv", true))) {
            writer.writeNext(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createAndWriteToXNL() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        Document document = builder.newDocument();

        Element staff = document.createElement("staff");
        document.appendChild(staff);
        Element employee1 = document.createElement("employee");
        employee1.setAttribute("id", "1");
        employee1.setAttribute("firstName", "John");
        employee1.setAttribute("lastName", "Smith");
        employee1.setAttribute("country", "USA");
        employee1.setAttribute("age", "25");
        staff.appendChild(employee1);

        Element employee2 = document.createElement("employee");
        employee2.setAttribute("id", "2");
        employee2.setAttribute("firstName", "Inav");
        employee2.setAttribute("lastName", "Petrov");
        employee2.setAttribute("country", "RU");
        employee2.setAttribute("age", "23");
        staff.appendChild(employee2);

        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("data.xml"));
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
            transformer.transform(domSource, streamResult);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
