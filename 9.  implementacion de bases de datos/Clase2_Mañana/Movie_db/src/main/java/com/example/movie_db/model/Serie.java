package com.example.movie_db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String title;
    private LocalDate release_date;
    private LocalDate end_date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "genre_id")
    private Genres genres;
}
