package com.example.covid19.entity;


public class Symthomp implements ISympthomp {
    private Integer code;
    private String name;
    private Integer levelSeverity;
    public Symthomp(Integer code, String name, Integer levelSeverity) {
        this.code = code;
        this.name = name;
        this.levelSeverity = levelSeverity;
    }
    @Override
    public Integer getCode() {
        return code;
    }
    @Override
    public void setCode(Integer code) {
        this.code = code;
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
    public Integer getLevelSeverity() {
        return levelSeverity;
    }
    @Override
    public void setLevelSeverity(Integer levelSeverity) {
        this.levelSeverity = levelSeverity;
    }
}
