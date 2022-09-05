package com.meli.seguroshql.dto;

import com.meli.seguroshql.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinisterDto {

    private Long id;
    private LocalDate date;
    private Double economicLoss;
    private Vehicle vehicle;
}
