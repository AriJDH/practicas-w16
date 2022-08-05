package com.bootcamp.ejerciciocovid19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRiskPersonDto {
    private List<RiskPersonDto> persons;
    private String message;
}
