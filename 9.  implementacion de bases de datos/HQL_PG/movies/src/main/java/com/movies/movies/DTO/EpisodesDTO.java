package com.movies.movies.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpisodesDTO {

    Integer id;
    String title;
    Integer number;
    LocalDate release_date;
    Double rating;
    Integer season_id;
}
