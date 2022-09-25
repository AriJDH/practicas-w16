package com.bootcamp.ejerciciosHQL.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seasons")
public class Season {
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
    private Date releaseDate;
    @Column(name = "end_date")
    private LocalDate endDate;

    //Relación OneToMany con serie. Aquí creao el campo serie_id
    @ManyToOne
    @JoinColumn(name="serie_id", nullable = false)
    private Serie serieSeason;

    //Relación OneToMany con Episode
    @OneToMany(mappedBy = "seasonEpisodes")
    private Set<Episode> episodeSet;
}
