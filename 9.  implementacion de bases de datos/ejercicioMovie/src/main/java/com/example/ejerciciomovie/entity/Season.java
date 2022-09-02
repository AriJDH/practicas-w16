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
@Table(name = "seasons")

public class Season {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE )
    private Long id;
    private String title;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Integer number;
    private LocalDate releaseDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name="serie_id",nullable = false)
    private Serie serie;

    /*@OneToMany(mappedBy = "season")
    private Set<Episode> episodeSet;*/
}
