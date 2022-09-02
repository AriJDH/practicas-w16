package com.movies.movies.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviesDTO {
    Integer id;
    String title;
    Double rating;
    Integer awards;
    LocalDate release_date;
    Integer length;
    Integer genre_id;
}
