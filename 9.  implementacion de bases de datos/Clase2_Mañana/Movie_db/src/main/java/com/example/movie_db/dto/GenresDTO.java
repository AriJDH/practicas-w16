package com.example.movie_db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenresDTO {
    private int id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String name;
    private double rating;
    private boolean active;
}
