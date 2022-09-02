package com.movies.movies.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Episodes {
    @Id
    Integer id;
    LocalDate created_at;
    LocalDate updated_at;
    String title;
    Integer number;
    LocalDate release_date;
    Double rating;

    @ManyToOne
    @JoinColumn(name= "season_id")
    Seasons season;

    @ManyToMany
    @JoinTable(
            name="actor_episode",
            joinColumns = @JoinColumn(name="episode_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    Set<Actors> actors;

}
