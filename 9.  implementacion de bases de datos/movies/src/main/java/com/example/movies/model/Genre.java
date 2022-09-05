package com.example.movies.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "update_at")
    private Date updateAt;
    @Column(length = 500)
    private String name;

    private Integer ranking;
    private Boolean active;

    @OneToMany(mappedBy = "genre")
    private List<Movie> movies;

    @OneToMany(mappedBy = "genre")
    private List<Serie> series;



}
