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
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate update_at;
    private String title;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(name = "end_date")
    private LocalDate endDate;

    //Relación OneToMany con genre. Aquí creao el campo genre_id
    @ManyToOne
    @JoinColumn(name="genre_id", nullable = false)
    private Genre genreSerie;

    //Relación OneToMany con Season
    @OneToMany(mappedBy = "serieSeason")
    private Set<Season> seasonsSet;

}
