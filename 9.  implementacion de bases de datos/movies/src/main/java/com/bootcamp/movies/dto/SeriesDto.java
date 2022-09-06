package com.bootcamp.movies.dto;

import com.bootcamp.movies.models.Season;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeriesDto {

    private Long id;

    private LocalDate createdAt;

    private LocalDate updateAt;

    private String title;

    private LocalDate releaseDate;

    private LocalDate endDate;

    private GenreDto genre;

    private List<Season> seasons;

}
