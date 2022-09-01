package com.movies.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate releaseDate;
}
