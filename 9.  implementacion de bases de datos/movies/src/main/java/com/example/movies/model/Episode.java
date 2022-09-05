package com.example.movies.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "update_at")
    private Date updateAt;
    @Column(length = 500)
    private String title;

    private Integer number;

    @Column(name = "release_date")
    private Timestamp releaseDate;
    @Column(name = "end_date")
    private Timestamp endDate;

    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;

    @ManyToMany(mappedBy = "likedEpisodes")
    private List<Actor> actors;


}
