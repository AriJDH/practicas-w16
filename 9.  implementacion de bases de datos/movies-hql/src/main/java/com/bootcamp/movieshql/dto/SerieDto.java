package com.bootcamp.movieshql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SerieDto {
    private Integer id;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private String title;

    private LocalDate releaseDate;

    private LocalDate endDate;
}
