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
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate update_at;
    private String title;
    private Integer number;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private Double rating;

    //Relación OneToMany con episodes. Aquí creao el campo season_id
    @ManyToOne
    @JoinColumn(name="season_id", nullable = false)
    private Season seasonEpisodes;

    //Relación ManyToMany con actor
    @ManyToMany(mappedBy = "likedEpisodes")
    private Set<Actor> likesEpiActor;
}
