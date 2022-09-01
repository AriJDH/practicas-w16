package com.movies.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDto {

    private String title;
    private Integer number;
    private LocalDate releaseDate;
}
