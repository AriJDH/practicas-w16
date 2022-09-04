package com.bootcamp.movieshql.dto;

import com.bootcamp.movieshql.model.Actor;
import com.bootcamp.movieshql.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private Integer id;

    private String title;

    private Double rating;

    private Integer awards;

    private Integer length;

    private String genreName;
}
