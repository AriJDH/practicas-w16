package com.movies.api.dto;

import com.movies.api.model.Episode;
import com.movies.api.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto {


    private String firstName;

    private String lastName;

    private Integer rating;

    //private Long favoriteMovie;
    private MovieDto movie;


}
