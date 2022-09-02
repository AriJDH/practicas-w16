package com.example.practicahql.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO {

    private Long id;
    private String first_name;
    private String last_name;
    private Double rating;
    private Long favorite_movie_id;
}
