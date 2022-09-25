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
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate update_at;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Double rating;

    //Relación OneToMany con actor. Aquí creao el campo favorite_movies_id
    @ManyToOne
    @JoinColumn(name="favorite_movie_id", nullable = false)
    private Movie movieActor;

    //Relacion ManyToMany con movie, aquí crea una tabla: actor_movie
    @ManyToMany
    @JoinTable(
            name="actor_movie",
            joinColumns = @JoinColumn(name = "actor_id"),//@JoinColumn(name = "created_at"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<Movie> likedMovies;

    //Relacion ManyToMany con episode, aquí crea una tabla: actor_episode
    @ManyToMany
    @JoinTable(
            name="actor_episode",
            joinColumns = @JoinColumn(name = "actor_id"),//@JoinColumn(name = "created_at"),
            inverseJoinColumns = @JoinColumn(name = "episode_id")
    )
    private Set<Episode> likedEpisodes;
}
