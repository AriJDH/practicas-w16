package com.example.movies.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "update_at")
    private Date updateAt;
    @Column(length = 500)
    private String title;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;
}
