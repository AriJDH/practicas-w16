package com.bootcamp.movies.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updateAt;
    private String title;
    private Double rating;
    private Integer awards;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private Integer length;
    @ManyToOne
    private Genre genre;
    @ManyToMany
    private Set<Actor> actors;
}
