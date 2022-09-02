package com.tomas.movieshql.service;

import com.tomas.movieshql.dto.*;
import com.tomas.movieshql.repository.IActorRepository;
import com.tomas.movieshql.repository.IEpisodeRepository;
import com.tomas.movieshql.repository.IMovieRepository;
import com.tomas.movieshql.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService{

    @Autowired
    IActorRepository actorRepository;

    @Autowired
    IMovieRepository movieRepository;

    @Autowired
    ISerieRepository serieRepository;

    @Autowired
    IEpisodeRepository episodeRepository;


    @Override
    public ListActorDTO searchActorFavoriteMovie() {

        ListActorDTO list = new ListActorDTO();

        list.setActors(actorRepository.findActorWithFavoriteMovie().stream().map(x->{
            ActorDTO actorDTO = new ActorDTO();
            actorDTO.setId(x.getId());
            actorDTO.setFirstName(x.getFirstName());
            actorDTO.setLastName(x.getLastName());
            actorDTO.setRating(x.getRating());
            return actorDTO;
        }).collect(Collectors.toList()));

        return list;

    }

    @Override
    public ListActorDTO searchActorRating(float rating) {

        ListActorDTO list = new ListActorDTO();

        list.setActors(actorRepository.findActorByRaiting(rating).stream().map(x->{
            ActorDTO actorDTO = new ActorDTO();
            actorDTO.setId(x.getId());
            actorDTO.setFirstName(x.getFirstName());
            actorDTO.setLastName(x.getLastName());
            actorDTO.setRating(x.getRating());
            return actorDTO;
        }).collect(Collectors.toList()));

        return list;

    }

    @Override
    public ListActorDTO searchActorMovie(String nameMovie) {

        ListActorDTO list = new ListActorDTO();

        list.setActors(movieRepository.findActorsByMovie(nameMovie).stream().map(x->{
            ActorDTO actorDTO = new ActorDTO();
            actorDTO.setId(x.getId());
            actorDTO.setFirstName(x.getFirstName());
            actorDTO.setLastName(x.getLastName());
            actorDTO.setRating(x.getRating());
            return actorDTO;
        }).collect(Collectors.toList()));

        return list;
    }


    @Override
    public ListMovieDTO searchMovieRatingActor(float rating) {

        ListMovieDTO list = new ListMovieDTO();

        list.setMovies(movieRepository.findMovieByActorRating(rating).stream().map(x->{
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setId(x.getId());
            movieDTO.setRating(x.getRating());
            movieDTO.setAwards(x.getAwards());
            movieDTO.setTitle(x.getTitle());
            movieDTO.setLength(x.getLength());
            movieDTO.setReleaseDate(x.getReleaseDate());
            return movieDTO;
        }).collect(Collectors.toList()));

        return list;
    }


    @Override
    public ListMovieDTO searchMovieByGenre(String nameGenre) {

        ListMovieDTO list = new ListMovieDTO();

        list.setMovies(movieRepository.findMovieByGenre(nameGenre).stream().map(x->{
            MovieDTO movieDTO = new MovieDTO();
            movieDTO.setId(x.getId());
            movieDTO.setRating(x.getRating());
            movieDTO.setAwards(x.getAwards());
            movieDTO.setTitle(x.getTitle());
            movieDTO.setLength(x.getLength());
            movieDTO.setReleaseDate(x.getReleaseDate());
            return movieDTO;
        }).collect(Collectors.toList()));

        return list;
    }


    @Override
    public ListSerieDTO searchSerieWithMaxSeason(int amountSeason) {

        ListSerieDTO list = new ListSerieDTO();

        list.setSeries(serieRepository.findBySeriesMaxSeason(amountSeason).stream().map(x->{
            SerieDTO serieDTO = new SerieDTO();
            serieDTO.setId(x.getId());
            serieDTO.setTitle(x.getTitle());
            serieDTO.setReleaseDate(x.getReleaseDate());
            serieDTO.setEndDate(x.getEndDate());
            return serieDTO;
        }).collect(Collectors.toList()));

        return list;
    }

    @Override
    public ListEpisodeDTO searchEpisodeByActor(String firstName, String lastName) {

        ListEpisodeDTO list = new ListEpisodeDTO();

        list.setEpisodes(episodeRepository.findEpisodeByActor(firstName, lastName).stream().map(x->{
            EpisodeDTO episodeDTO = new EpisodeDTO();
            episodeDTO.setId(x.getId());
            episodeDTO.setRating(x.getRating());
            episodeDTO.setTitle(x.getTitle());
            episodeDTO.setReleaseDate(x.getReleaseDate());
            episodeDTO.setNumber(x.getNumber());
            return episodeDTO;
        }).collect(Collectors.toList()));

        return list;
    }

}
