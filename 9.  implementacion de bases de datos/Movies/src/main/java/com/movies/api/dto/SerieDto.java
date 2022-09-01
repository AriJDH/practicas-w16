package com.movies.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerieDto {

    private String title;
    private LocalDate releaseDate;
    private Integer seasons;
}
