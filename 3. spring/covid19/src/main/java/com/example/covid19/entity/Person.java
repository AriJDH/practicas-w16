package com.example.covid19.entity;


public class Person implements IPerson {
    static private Integer nextId = 0;
    private Integer id;
    private String name;
    private String lastName;
    private Integer age;

    public Person() {
        this.id = this.nextId++;
    }

    public Person(String name, String lastName, Integer age) {
        this.id = this.nextId++;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
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
}
