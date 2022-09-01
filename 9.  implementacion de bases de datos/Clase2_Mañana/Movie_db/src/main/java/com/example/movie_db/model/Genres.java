package com.example.movie_db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "genres")
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String name;
    private double rating;
    private boolean active;
    /*
    @OneToMany(mappedBy = "genres")
    private Set<Movie> movies;
     */
}
