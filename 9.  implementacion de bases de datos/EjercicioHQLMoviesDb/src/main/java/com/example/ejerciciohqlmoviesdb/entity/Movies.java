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
@Table(name="movies")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="created_at")
    private Date created_at;

    @Column(name="updated_at")
    private Date updated_at;

    @Column(name="title")
    private String title;

    @Column(name="rating")
    private Long rating;

    @Column(name="awards")
    private Integer awards;

    @Column(name="release_date")
    private Date release_date;

    @Column(name="length")
    private Integer length;

    @OneToMany(mappedBy = "favorite_movie")
    private Set<Actors> actors;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    private Genres genre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="Actor_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name="actor_id")
    )
    private Set<Actors> actors_movie;

}
