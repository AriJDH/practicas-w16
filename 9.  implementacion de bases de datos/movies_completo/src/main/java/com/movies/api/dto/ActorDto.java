package com.movies.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.movies.api.model.Episode;
import com.movies.api.model.Movie;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorDto {
    private String firstName;
    private String lastName;
    private Double rating;
    private MovieDto favoriteMovie;
    //private MovieDto movie;
}
