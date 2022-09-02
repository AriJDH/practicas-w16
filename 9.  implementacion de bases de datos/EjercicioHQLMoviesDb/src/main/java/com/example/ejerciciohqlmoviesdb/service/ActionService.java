package com.example.ejerciciohqlmoviesdb.service;

import com.example.ejerciciohqlmoviesdb.dto.ActorInfoDto;
import com.example.ejerciciohqlmoviesdb.dto.EpisodeDto;
import com.example.ejerciciohqlmoviesdb.dto.MovieDto;
import com.example.ejerciciohqlmoviesdb.dto.SerieDto;
import com.example.ejerciciohqlmoviesdb.entity.Actors;
import com.example.ejerciciohqlmoviesdb.entity.Episodes;
import com.example.ejerciciohqlmoviesdb.entity.Movies;
import com.example.ejerciciohqlmoviesdb.entity.Series;
import com.example.ejerciciohqlmoviesdb.repository.IActorRepository;
import com.example.ejerciciohqlmoviesdb.repository.IMovieRepository;
import com.example.ejerciciohqlmoviesdb.repository.ISeriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActionService implements IActionsService {

    private final IActorRepository actorRepo;

    private final IMovieRepository movieRepository;

    private final ISeriesRepository seriesRepository;

    public ActionService(IActorRepository actorRepo,IMovieRepository movieRepository,ISeriesRepository seriesRepository) {
        this.actorRepo = actorRepo;this.movieRepository = movieRepository;;this.seriesRepository = seriesRepository;
    }

    @Override
    public List<ActorInfoDto> getActorsWfavoriteMovie() {
        List<Actors> listaActores = actorRepo.getActorsWfavoriteMovie();
        return listaActores.stream().map(x->mapActor(x)).collect(Collectors.toList());
    }

    @Override
    public List<ActorInfoDto> getActorsWithRatingHigherThan(long rating) {
        List<Actors> listaActores = actorRepo.getActorsWithRatingHigherThan(rating);
        return listaActores.stream().map(x->mapActor(x)).collect(Collectors.toList());
    }

    @Override
    public List<ActorInfoDto> getActorsThatWorkedOnAMovie(String movie) {
        List<Actors> listaActores = actorRepo.getActorsThatWorkedOnAMovie(movie);
        return listaActores.stream().map(x->mapActor(x)).collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> getMoviesWithActorsHigherThanRate(long minRating) {
        List<Movies> listaMovies = movieRepository.getMoviesWithActorsHigherThanRate(minRating);
        return listaMovies.stream().map(x->mapMovie(x)).collect(Collectors.toList());
    }

    @Override
    public List<MovieDto> GetMoviesWithGenre(String genreName) {
        List<Movies> listaMovies = movieRepository.GetMoviesWithGenre(genreName);
        return listaMovies.stream().map(x->mapMovie(x)).collect(Collectors.toList());
    }

    @Override
    public List<SerieDto> seriesWithmoreSeasonsThan(Long ammount) {
        List<Series> listaSerie = seriesRepository.seriesWithmoreSeasonsThan(ammount);
        return listaSerie.stream().map(x->mapSerie(x)).collect(Collectors.toList());
    }

    @Override
    public List<EpisodeDto> getEpisodesWhereActorWorked(String actorFirstName,String actorLastName) {
        List<Episodes> listaSerie = actorRepo.getEpisodesWhereActorWorked(actorFirstName,actorLastName);
        return listaSerie.stream().map(x->mapEpisode(x)).collect(Collectors.toList());
    }

    private ActorInfoDto mapActor(Actors actor){
        return new ActorInfoDto(actor.getId(),actor.getFirst_name(),actor.getLast_name(),actor.getCreated_at(),actor.getUpdated_at(),actor.getRating());
    }

    private MovieDto mapMovie(Movies movie){
        return new MovieDto(movie.getId(), movie.getCreated_at(),movie.getUpdated_at(),movie.getTitle(),movie.getRating(),movie.getAwards(),movie.getRelease_date(),movie.getLength());
    }

    private SerieDto mapSerie(Series serie){
        return new SerieDto(serie.getId(), serie.getCreated_at(),serie.getUpdated_at(),serie.getTitle(),serie.getRelease_date(),serie.getEnd_date());
    }

    private EpisodeDto mapEpisode(Episodes episode){
        return new EpisodeDto(episode.getId(), episode.getCreated_at(),episode.getUpdated_at(),episode.getTitle(), episode.getNumber(),episode.getRelease_date(), episode.getRating());
    }
}
