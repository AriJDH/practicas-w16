package com.example.covid19.entity;


public class PersonSympthomp implements  IPersonSympthomp {
    static private Integer nextId = 0;
    private Integer id;
    private Integer personId;
    private Integer codeId;

    public PersonSympthomp() {
        this.id = this.nextId++;
    }

    public PersonSympthomp(Integer personId, Integer codeId) {
        this.id = this.nextId++;
        this.personId = personId;
        this.codeId = codeId;
    }

    public Integer getId() {
        return id;
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public Integer getPersonId() {
        return personId;
    }
    @Override
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
    @Override
    public Integer getCodeId() {
        return codeId;
    }
    @Override
    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }
}
