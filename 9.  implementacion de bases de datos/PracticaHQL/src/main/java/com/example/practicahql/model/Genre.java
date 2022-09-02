package com.example.practicahql.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "genres")
@Data
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String name;
    private int ranking;
    private boolean active;

   /* @OneToMany(mappedBy = "movies")
    private Set<Movie> movies;

    @OneToMany(mappedBy = "series")
    private Set<Serie> series; */

}
