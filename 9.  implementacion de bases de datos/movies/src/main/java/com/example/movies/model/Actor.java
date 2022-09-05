package com.example.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "actors")
@Data @AllArgsConstructor @NoArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "update_at")
    private Date updateAt;
    @Column(length = 100,name = "first_name")
    private String firstName;
    @Column(length = 100,name = "last_name")
    private String lastName;

    private Double rating;


    @ManyToOne
    @JoinColumn(name = "favorite_movie", nullable = false)
    private Movie favoriteMovie;


    @ManyToMany
    @JoinTable(
            name = "actor_episode",
            joinColumns = @JoinColumn(name = "actor_id",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "episode_id", nullable = false)
    )
    private List<Episode> likedEpisodes;

    @ManyToMany
    @JoinTable(name = "actor_movie",
    joinColumns = @JoinColumn(name = "actor_id",nullable = false),
    inverseJoinColumns = @JoinColumn(name = "movie_id", nullable = false))
    private List<Movie> Likedmovies;

}