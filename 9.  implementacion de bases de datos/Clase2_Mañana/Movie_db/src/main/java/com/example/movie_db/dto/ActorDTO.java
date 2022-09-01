package com.example.movie_db.dto;

import com.example.movie_db.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActorDTO {
    private int id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String first_name;
}
