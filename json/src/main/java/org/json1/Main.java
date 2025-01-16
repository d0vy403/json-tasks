package org.json1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Person archer = new Person("Legolas", 1525, "lego@mirkwood.me");
        Person warrior = new Person("Gimli", 354, "gim@moria.me");
        Person wizard = new Person("Gandalf", 3501, "gndlf@council.me");

        Map<String, Person> personMap = new LinkedHashMap<>();
        personMap.put("archer", archer);
        personMap.put("warrior", warrior);
        personMap.put("wizard", wizard);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        File output = new File("rezultatas.json");
        objectMapper.writeValue(output, personMap);

        System.out.println("JSON file created: " + output.getAbsolutePath());

        Map<String, Person> deserializedPersonMap = objectMapper.readValue(
                output, objectMapper.getTypeFactory().constructMapType(Map.class, String.class, Person.class)
        );

        System.out.println("Original: " + personMap);
        System.out.println("Deserialized: " + deserializedPersonMap);

        System.out.println("Objects are equal: " + personMap.equals(deserializedPersonMap));


    }
}