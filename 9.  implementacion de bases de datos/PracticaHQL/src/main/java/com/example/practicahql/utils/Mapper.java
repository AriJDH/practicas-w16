package com.example.practicahql.utils;

import com.example.practicahql.dtos.ActorDTO;
import com.example.practicahql.dtos.EpisodeDTO;
import com.example.practicahql.dtos.MovieDTO;
import com.example.practicahql.dtos.SerieDTO;
import com.example.practicahql.model.Actor;
import com.example.practicahql.model.Episode;
import com.example.practicahql.model.Movie;
import com.example.practicahql.model.Serie;

public class Mapper {

    public static ActorDTO getDTOFromActor(Actor a){
        return new ActorDTO(a.getId(),
                a.getFirst_name(),
                a.getLast_name(),
                a.getRating(),
                ((a.getFavorite_movie_id() == null) ? null : a.getFavorite_movie_id().getId()));
    }

    public static MovieDTO getDTOFromMovie(Movie m){
        return new MovieDTO(m.getId(),
                m.getTitle(),
                m.getRating(),
                m.getAwards(),
                m.getRelease_date(),
                m.getLength(),
                ((m.getGenre() == null) ? null : m.getGenre().getId()));
    }

    public static SerieDTO getDTOFromSerie(Serie s){
        return new SerieDTO(s.getId(),
                s.getTitle(),
                s.getRelease_date(),
                s.getEnd_date(),
                ((s.getGenre() == null) ? null : s.getGenre().getId()));
    }

    public static EpisodeDTO getDTOFromEpisode(Episode e){
        return new EpisodeDTO(e.getId(),
                e.getTitle(),
                e.getNumber(),
                e.getRelease_date(),
                e.getRating(),
                e.getSeason().getId());
    }
}
