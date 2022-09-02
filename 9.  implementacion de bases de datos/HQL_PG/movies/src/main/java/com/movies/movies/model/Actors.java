package com.movies.movies.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Actors {
    @Id
    Integer id;
    LocalDate created_at;
    LocalDate updated_at;
    String first_name;
    String last_name;
    Double rating;
    @ManyToOne
    @JoinColumn(name= "favorite_movie_id")
    Movies movie;
    @ManyToMany
    @JoinTable(
            name="actor_movie",
            joinColumns = @JoinColumn(name="actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    Set<Movies> movies_actors;
}
