package com.example.practicahql.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeasonDTO {

    private Long id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String title;
    private int number;
    private LocalDate release_date;
    private LocalDate end_date;
    private SerieDTO serie;
}
