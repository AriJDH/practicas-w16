package com.example.ejerciciomovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Double rating;
    private Double awards;
    private LocalDate releaseDate;
    private Integer length;

    @ManyToOne
    @JoinColumn(name = "genre_id",nullable = true)
    private Genre genres;


    /*
    solo una direccion
    @OneToMany(mappedBy = "movie")
    private Set<Actor> actor;
*/
    /*@ManyToMany(mappedBy = "movie")
    private Set<Actor> actors;*/

}
