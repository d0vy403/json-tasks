package org.json1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Legolas", 1525, "lego@mirkwood.me"));
        personList.add(new Person("Gimli", 354, "gim@moria.me"));
        personList.add(new Person("Gandalf", 3501, "gndlf@council.me"));

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonString = objectMapper.writeValueAsString(personList);
        System.out.println(jsonString);

        File output = new File("src/main/java/org/json1/persons.json");
        objectMapper.writeValue(output, personList);

        System.out.println("JSON file created: " + output.getAbsolutePath());

        List<Person> deserializedPersonList = objectMapper.readValue(
                new File("src/main/java/org/json1/persons.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Person.class)
        );

        System.out.println("Original: " + personList);
        System.out.println("Deserialized: " + deserializedPersonList);

        boolean areListsEqual = personList.equals(deserializedPersonList);
        System.out.println("Objects are equal: " + areListsEqual);


    }
}