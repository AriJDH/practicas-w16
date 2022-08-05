package com.bootcamp.ejerciciocovid19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RiskPersonDto {

    private String name;
    private String subName;
    private Integer age;
}
