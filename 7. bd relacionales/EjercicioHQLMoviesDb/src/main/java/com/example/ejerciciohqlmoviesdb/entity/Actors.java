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
@Table(name="actors")
public class Actors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="created_at")
    private Date created_at;

    @Column(name="updated_at")
    private Date updated_at;

    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="rating")
    private long rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "favorite_movie_id", nullable = false)
    private Movies favorite_movie;


    @ManyToMany(mappedBy = "actors_movie")
    private Set<Movies> movies;

    @ManyToMany(mappedBy = "actor_episode")
    private Set<Episodes> episodes;




}
