package com.example.ejerciciomovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "genres")

public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String name;
    private Double active;

    /*
    No me interesa quien tenga mi genero.
    @OneToMany(mappedBy = "genres")
    private Set<Movie> movie;
    @OneToOne(mappedBy = "genres")
    private Serie serie;
    */


}
