package com.example.ejerciciohqlmoviesdb.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="genres")
public class Genres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="created_at")
    private Date created_at;

    @Column(name="updated_at")
    private Date updated_at;

    @Column(name="name")
    private String name;

    @Column(name="ranking")
    private Integer ranking;

    @Column(name="active")
    private Short active;


    @OneToMany(mappedBy = "genre")
    private Set<Movies> movies;

    @OneToMany(mappedBy = "genre")
    private Set<Series> series;

}
