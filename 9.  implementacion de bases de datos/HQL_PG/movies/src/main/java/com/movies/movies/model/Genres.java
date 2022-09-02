package com.movies.movies.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Genres {

    @Id
    Integer id;
    LocalDate created_at;
    LocalDate updated_at;
    String name;
    Integer ranking;
    Integer active;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name= "genre_id")
    private List<Movies> movies;
}
