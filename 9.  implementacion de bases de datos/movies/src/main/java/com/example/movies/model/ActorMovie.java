package com.example.movies.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "actor_movie")
@IdClass(value = ActorMovieId.class)
public class ActorMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "update_at")
    private Date updateAt;

    @Id
    @Column(name = "actor_id")
    private Integer actorId;

    @Id
    @Column(name = "movie_id")
    private Integer movieId;

}
