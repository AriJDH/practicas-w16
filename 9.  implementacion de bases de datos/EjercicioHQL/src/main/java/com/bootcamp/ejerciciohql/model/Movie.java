package com.bootcamp.ejerciciohql.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    @Id
    Long id;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;
    private String title;
    private Double rating;
    private Integer awards;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private Integer length;
    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

   /* @OneToMany(mappedBy = "favoriteMovie")
    private Set<Actor> actorsFavoriteMovie;*/

}
