package com.bootcamp.movies.dto;

import com.bootcamp.movies.models.Actor;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDto {
    private Long id;

    private LocalDate createdAt;

    private LocalDate updateAt;

    private String title;

    private Integer number;

    private LocalDate releaseDate;

    private Double rating;

    private Set<ActorDto> cast;
}
