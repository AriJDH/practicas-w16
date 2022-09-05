package com.example.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorEpisodeId implements Serializable {

    @Column(name = "actor_id")
    private Integer actorId;
    @Column(name = "episode_id")
    private Integer episodeId;

}
