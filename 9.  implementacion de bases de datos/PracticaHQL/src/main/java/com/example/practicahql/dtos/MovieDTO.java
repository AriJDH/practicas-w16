package com.example.practicahql.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private Long id;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate release_date;
    private Integer length;
    private Long genre_id;
}
