package com.example.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ActorMovieId implements Serializable {

    @Column(name = "actor_id")
    private Integer actorId;
    @Column(name = "movie_id")
    private Integer movieId;

}
