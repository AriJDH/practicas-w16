package com.bootcamp.practico.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Symptom {

    private int id;
    private String name;
    private int level;
}
