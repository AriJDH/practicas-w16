package com.bootcamp.aplication.DTO;

public class RiskPersonDTO {
    private String name;
    private String lastName;

    public RiskPersonDTO() {
    }

    public RiskPersonDTO(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "RiskPersonDTO{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
