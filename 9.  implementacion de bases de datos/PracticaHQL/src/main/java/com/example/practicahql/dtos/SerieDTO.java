package com.example.practicahql.dtos;

import com.example.practicahql.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerieDTO {

    private Long id;
    private String title;
    private LocalDate release_date;
    private LocalDate end_date;
    private Long genre_id;
}
