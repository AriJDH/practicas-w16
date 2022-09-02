package com.example.ejerciciohqlmoviesdb.service;

import com.example.ejerciciohqlmoviesdb.dto.ActorInfoDto;
import com.example.ejerciciohqlmoviesdb.dto.EpisodeDto;
import com.example.ejerciciohqlmoviesdb.dto.MovieDto;
import com.example.ejerciciohqlmoviesdb.dto.SerieDto;
import com.example.ejerciciohqlmoviesdb.entity.Actors;
import com.example.ejerciciohqlmoviesdb.entity.Series;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActionsService {
    List<ActorInfoDto> getActorsWfavoriteMovie();

    List<ActorInfoDto> getActorsWithRatingHigherThan(long rating);
    List<ActorInfoDto> getActorsThatWorkedOnAMovie(String movie);

    List<MovieDto> getMoviesWithActorsHigherThanRate(long minRating);

    List<MovieDto> GetMoviesWithGenre(String genreName);

    List<SerieDto> seriesWithmoreSeasonsThan( Long ammount);

    List<EpisodeDto> getEpisodesWhereActorWorked(String actorFirstName,String actorLastName);

}
