package com.example.ejerciciodosvivo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseTestDto {

    Long id;
    String description;
    Boolean tested;
    Boolean passed;
    Integer numberOfTries;
    LocalDate lastUpdate;
}
