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
public class Movies {
    @Id
    Integer id;
    LocalDate created_at;
    LocalDate updated_at;
    String title;
    Double rating;
    Integer awards;
    LocalDate release_date;
    Integer length;
    @ManyToMany(mappedBy = "movies_actors")
    Set<Actors> actor_movie;
    @ManyToOne
    @JoinColumn(name= "genre_id")
    Genres genre;

}
