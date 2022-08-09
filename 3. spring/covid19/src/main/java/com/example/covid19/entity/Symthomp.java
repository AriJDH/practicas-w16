package com.example.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Symthomp {
    private Integer code;
    private String name;
    private Integer levelSeverity;
}
