package com.example.movies.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "actor_episode")
@IdClass(ActorEpisodeId.class)
public class ActorEpisode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "update_at")
    private Date updateAt;

    @Id
    @Column(name = "actor_id")
    private Integer actorId;

    @Id
    @Column(name = "episode_id")
    private Integer episodeId;
}
