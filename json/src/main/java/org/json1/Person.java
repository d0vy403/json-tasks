package org.json1;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    @JsonProperty("vardas")
    private String name;
    @JsonProperty("amžius")
    private int age;
    @JsonProperty("el.paštas")
    private String email;

    public Person(){

    }

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age &&
                name.equals(person.name) &&
                email.equals(person.email);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, age, email);
    }
}
