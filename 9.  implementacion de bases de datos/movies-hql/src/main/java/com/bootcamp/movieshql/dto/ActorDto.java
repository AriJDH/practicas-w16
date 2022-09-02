package com.bootcamp.movieshql.dto;

import com.bootcamp.movieshql.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private Double rating;

    private Movie favoriteMovie;
}
