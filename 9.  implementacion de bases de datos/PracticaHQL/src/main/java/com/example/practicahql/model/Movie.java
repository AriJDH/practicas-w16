package com.example.practicahql.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "movies")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate release_date;
    private Integer length;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    /*
    @OneToMany(mappedBy = "actors")
    private Set<Actor> actorsFav;
     */
}
