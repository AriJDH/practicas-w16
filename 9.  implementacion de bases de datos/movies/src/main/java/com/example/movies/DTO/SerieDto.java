package com.example.movies.DTO;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Data
public class SerieDto implements Serializable {
    private final Long id;
    private final String title;
    private final LocalDate releaseDate;
    private final LocalDate endDate;
}
