package com.tomas.movieshql.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="seasons")
public class Season {

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

    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Serie serie;


}
