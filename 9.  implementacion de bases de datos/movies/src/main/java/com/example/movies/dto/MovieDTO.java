package com.example.movies.dto;

import com.example.movies.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private Integer id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDateTime releaseDate;
    private Integer length;
    private Genre genre;

}
