package com.example.movie_db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String title;
    private int number;
    private LocalDate release_date;
    private double rating;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "season_id",referencedColumnName = "id")
    private Season season;
    @ManyToMany()
    @JoinTable(name="actor_episode",
            joinColumns = @JoinColumn(name = "episode_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actors;
}
