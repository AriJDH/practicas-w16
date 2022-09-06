package com.bootcamp.movies.services;

import com.bootcamp.movies.dto.ActorDto;
import com.bootcamp.movies.dto.EpisodeDto;
import com.bootcamp.movies.dto.MovieDto;
import com.bootcamp.movies.dto.SeriesDto;
import com.bootcamp.movies.repositories.IActorRepository;
import com.bootcamp.movies.repositories.IEpisodesRepository;
import com.bootcamp.movies.repositories.IMoviesRepository;
import com.bootcamp.movies.repositories.ISeriesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceM {
     IMoviesRepository moviesRepository;
     IEpisodesRepository episodesRepository;
     IActorRepository actorRepository;
     ISeriesRepository seriesRepository;

     ModelMapper mapper;

    public ServiceM(IMoviesRepository moviesRepository, IEpisodesRepository episodesRepository, IActorRepository actorRepository, ISeriesRepository seriesRepository) {
        this.moviesRepository = moviesRepository;
        this.episodesRepository = episodesRepository;
        this.actorRepository = actorRepository;
        this.seriesRepository = seriesRepository;
        mapper = new ModelMapper();
    }

    private List<?>listToDto(List<?> list, Class classToMap){
        return list.stream()
                .map(e -> mapper.map(e,classToMap))
                .collect(Collectors.toList());
    }

    public List<?> actorsWithFavMovie(){
        return listToDto(actorRepository.findByFavoriteMovieNotNull(), ActorDto.class);
    }

    public List<?> actorsWithRatingHighThan(double rating){
        return listToDto(actorRepository.findByRatingGreaterThan(rating), ActorDto.class);
    }

    public List<?> actorsWorksIn(Long movieId){
        return listToDto(actorRepository.getActorsThatWorksIn(movieId), ActorDto.class);
    }

    public List<?> movieActorsRating(Double rating){
        return listToDto(moviesRepository.moviesWithActorRatingGreaterThan(rating), MovieDto.class);
    }

    public List<?> moviesGenreIs(Long genreId){
        return listToDto(moviesRepository.moviesByGenre(genreId), MovieDto.class);
    }

    public List<?> seriesWithSeasonsGreatherThan(Integer seasons){
        return listToDto(seriesRepository.seriesBySeasonsGreaterThan(seasons), SeriesDto.class);
    }

    public List<?> episodesThatActorWorks(Long id){
        return listToDto(episodesRepository.episodesWithActor(id),EpisodeDto.class);
    }
}
