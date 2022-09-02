package com.example.ejerciciomovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "episodes")

public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Double number;
    private LocalDate releaseDate;
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "season_id",nullable = true)
    private Season season;


    /*@ManyToMany(mappedBy = "episode")
    private Set<Actor> actors;*/

}
