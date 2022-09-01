package com.example.movie_db.dto;

import com.example.movie_db.model.Genres;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieDTO {
    private int id;
    private String title;
}
