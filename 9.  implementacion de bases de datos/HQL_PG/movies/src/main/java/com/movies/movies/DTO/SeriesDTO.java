package com.movies.movies.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeriesDTO {
    Integer id;
    String title;
    LocalDate release_date;
    LocalDate end_date;
    Integer genre_id;
}
