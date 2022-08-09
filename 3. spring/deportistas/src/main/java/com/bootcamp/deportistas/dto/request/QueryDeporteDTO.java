package com.bootcamp.deportistas.dto.request;

public class QueryDeporteDTO {
    private String name;

    public QueryDeporteDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
