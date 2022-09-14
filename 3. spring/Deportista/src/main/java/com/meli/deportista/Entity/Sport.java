package com.meli.deportista.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sport {
    private String name;
    private Integer level;
    private List<People> people;
}
