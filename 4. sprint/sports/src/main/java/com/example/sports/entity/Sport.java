package com.example.sports.entity;

public class Sport implements ISport {
    private static Integer nextId = 0;
    private Integer id;
    private String name;
    private Integer level;

    Sport() {
        this.id = nextId++;
    }

    Sport(String name, Integer level) {
        this.id = nextId++;
        this.name = name;
        this.level = level;
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
    public Integer getLevel() {
        return level;
    }

    @Override
    public void setLevel(Integer level) {
        this.level = level;
    }
}
