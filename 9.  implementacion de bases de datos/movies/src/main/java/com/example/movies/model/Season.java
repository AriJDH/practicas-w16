package com.example.movies.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "seasons")
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Data
public class Season {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "update_at")
    private Date updateAt;
    @Column(length = 500)
    private String title;

    private Integer number;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "serie_id", nullable = false)
    private Serie serie;

    @OneToMany(mappedBy = "season")
    private List<Episode> episodes;

}
