package com.bootcamp.movies.models;

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
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "first_name")

    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name="rating")
    private Double rating;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Movie favoriteMovie;

    @ManyToMany
    @JoinTable(
            name ="actor_movie",
            joinColumns = @JoinColumn(name="actor_id"),
            inverseJoinColumns = @JoinColumn(name="movie_id")
    )
    private Set<Movie> actedMovies;

}
