package com.example.practicahql.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDTO {

    private Long id;
    private String title;
    private int number;
    private LocalDate release_date;
    private double rating;
    private Long season_id;
}
