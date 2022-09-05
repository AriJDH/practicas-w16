package com.example.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "update_at")
    private Date updateAt;
    @Column(length = 500)
    private String title;


    private Double rating;
    private Integer awards;
    @Column(name = "release_date")
    private Date releaseDate;
    private Integer Length;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @ManyToMany(mappedBy = "Likedmovies")
    private List<Actor> actors;

    @OneToMany(mappedBy = "favoriteMovie")
    private List<Actor> actorsMovieFavorites;



}
