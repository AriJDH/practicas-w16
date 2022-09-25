package com.bootcamp.ejerciciosHQL.model;

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
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate update_at;
    private String name;
    private Integer ranking;
    private Integer active;

    //Relación OneToMany con movie
    @OneToMany(mappedBy = "genreMovie")
    private Set<Movie> movieSet;

    //Relación OneToMany con serie
    @OneToMany(mappedBy = "genreSerie")
    private Set<Serie> serieSet;

}
