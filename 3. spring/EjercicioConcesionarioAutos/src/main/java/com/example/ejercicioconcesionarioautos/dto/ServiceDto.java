package com.example.ejercicioconcesionarioautos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto {
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;
    private int kilometers;
    private String descriptions;
}
