package com.example.movies.Utils;

import com.example.movies.DTO.ActorDto;
import com.example.movies.DTO.MovieDto;
import com.example.movies.DTO.SerieDto;
import com.example.movies.Models.Actor;
import com.example.movies.Models.Movie;
import com.example.movies.Models.Serie;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    public static ActorDto mapActorDto(Actor actor) {
        return ActorDto
                .builder()
                .id(actor.getId())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .rating(actor.getRating())
                .build();
    }

    public static List<ActorDto> listMapActorDto(List<Actor> actors) {
        return actors
                .stream()
                .map(Mapper::mapActorDto)
                .collect(Collectors.toList());
    }
    public static MovieDto mapMovieDto(Movie movie) {
        return MovieDto
                .builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .rating(movie.getRating())
                .awards(movie.getAwards())
                .releaseDate(movie.getReleaseDate())
                .length(movie.getLength())
                .build();
    }

    public static List<MovieDto> listMapMovieDto(List<Movie> movies) {
        return movies
                .stream()
                .map(Mapper::mapMovieDto)
                .collect(Collectors.toList());
    }
    public static SerieDto mapSerieDto(Serie serie) {
        return SerieDto
                .builder()
                .id(serie.getId())
                .title(serie.getTitle())
                .releaseDate(serie.getReleaseDate())
                .endDate(serie.getEndDate())
                .build();
    }

    public static List<SerieDto> listMapSerieDto(List<Serie> serie) {
        return serie
                .stream()
                .map(Mapper::mapSerieDto)
                .collect(Collectors.toList());
    }
}
