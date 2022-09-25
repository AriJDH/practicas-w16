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
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate update_at;
    private String title;
    private Double rating;
    private Integer awards;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private Integer length;

    //Relación OneToMany con genre. Aquí creao el campo genre_id
    @ManyToOne
    @JoinColumn(name="genre_id", nullable = false)
    private Genre genreMovie;

    //Relación OneToMany con actor
    @OneToMany(mappedBy = "movieActor")
    private Set<Actor> actorSet;

    //Relación ManyToMany con actor
    @ManyToMany(mappedBy = "likedMovies")
    private Set<Actor> likesMoActor;
}
