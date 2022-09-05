package com.meli.movieshql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private String title;
    private Double raiting;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;
}
