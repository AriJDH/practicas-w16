package com.example.sports.entity;

public class Person implements IPerson {
    static Integer nextId = 0;
    Integer id;
    String name;
    String lastName;
    Integer age;
    Integer sportId;

    Person() {
        this.id = this.nextId++;
    }
    Person(String name, String lastName, Integer age, Integer sportId) {
        this.id = this.nextId++;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sportId = sportId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public Integer getSportId() {
        return sportId;
    }
    @Override
    public void setSportId(Integer sportId) {
        this.sportId = sportId;
    }
}
