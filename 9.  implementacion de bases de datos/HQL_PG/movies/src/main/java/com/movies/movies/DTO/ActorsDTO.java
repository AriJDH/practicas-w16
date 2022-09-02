package com.movies.movies.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorsDTO {

    Integer id;
    String first_name;
    String last_name;
    Double rating;
    private Integer favorite_movie_id;
}
