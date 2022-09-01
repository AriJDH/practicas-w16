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
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String title;
    private double rating;
    private int awards;
    private LocalDate release_date;
    private Integer length;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "genre_id")
    private Genres genres;
    @ManyToMany()
    @JoinTable(name="actor_movie",
                joinColumns = @JoinColumn(name = "movie_id"),
                inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actors;
}
