package com.example.practicahql.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "seasons")
@Data
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String title;
    private int number;
    private LocalDate release_date;
    private LocalDate end_date;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;

    /*
    @OneToMany(mappedBy = "episodes")
    private Set<Episode> episodes;
     */
}
