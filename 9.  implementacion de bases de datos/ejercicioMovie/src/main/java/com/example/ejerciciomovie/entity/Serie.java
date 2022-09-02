package com.example.ejerciciomovie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "series")

public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private LocalDate relaseDate;
    private LocalDate endDate;
    @OneToOne
    @JoinColumn(name = "genre_id",referencedColumnName = "id")
    private Genre genres;

    /*@OneToMany(mappedBy = "serie")
    private Set<Season> season;*/
}
