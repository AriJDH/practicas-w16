package com.bootcamp.ejerciciocovid19.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SymptomDTO {
        private String code;
        private String name;
        private int level_of_gravity;
}

