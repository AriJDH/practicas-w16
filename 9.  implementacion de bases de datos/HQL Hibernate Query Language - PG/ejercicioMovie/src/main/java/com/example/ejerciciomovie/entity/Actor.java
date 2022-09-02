package com.example.ejerciciomovie.entity;

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
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String firstName;
    private String lastName;
    private Double rating;


    @ManyToOne
    @JoinColumn(name = "favorite_movie_id",nullable = true)
    private Movie movies;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "actor_episode"
            , joinColumns = @JoinColumn(name = "actor_id")
            , inverseJoinColumns = @JoinColumn(name = "episode_id"))
    private Set<Episode> episode;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "actor_movie"
            , joinColumns = @JoinColumn(name = "actor_id")
            , inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> movie;
}
