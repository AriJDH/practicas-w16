package com.example.movies.DTO;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
public class MovieDto implements Serializable {
    private final Long id;
    private final String title;
    private final Double rating;
    private final Integer awards;
    private final LocalDate releaseDate;
    private final Integer length;
}
