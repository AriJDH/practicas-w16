package com.bootcamp.covid.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SymptomDTO {
    private String code;
    private String name;
    private int severity;
}
