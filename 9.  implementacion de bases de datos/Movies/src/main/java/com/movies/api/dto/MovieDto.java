package com.movies.api.dto;

import com.movies.api.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class MovieDto {

    private String title;
    private Double raiting;
    private Integer awards;



}
