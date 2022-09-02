package com.example.practicahql.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "episodes")
@Data
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String title;
    private int number;
    private LocalDate release_date;
    private double rating;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
}
