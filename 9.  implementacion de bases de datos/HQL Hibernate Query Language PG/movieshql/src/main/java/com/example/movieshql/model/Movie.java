package com.example.movieshql.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String title;
    private Double awards;
    private Date releaseDate;
    private Integer length;
   //private Integer genreId;

    //@OneToMany(mappedBy = "movie")
    //private Set<Actor> actors;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Genre genre;

   @ManyToMany(mappedBy = "movie")
    private Set<Actor> actors;
}
