package com.movies.api.model;

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
@Table(name="episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    private String title;

    private Integer number;

    private LocalDate releaseDate;

    private Double rating;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Season season;

    @ManyToMany(mappedBy = "episode")
    private Set<Actor> actors;
}
