package com.example.practicahql.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "series")
@Data
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String title;
    private LocalDate release_date;
    private LocalDate end_date;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    /*
    @OneToMany(mappedBy = "seasons")
    private List<Season> seasons;
     */
}
