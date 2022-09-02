package com.movies.movies.service;

import com.movies.movies.DTO.MoviesDTO;
import com.movies.movies.model.Movies;
import com.movies.movies.repository.IMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoviesService implements IMoviesService{

    @Autowired
    IMoviesRepository iMoviesRepository;

    @Override
    public List<MoviesDTO> getMoviesByGreaterActorRating(Double rating){
        List<Movies> movies = iMoviesRepository.findMoviesByActorRating(rating);
        List<MoviesDTO> moviesDTO = new ArrayList<>();
        Integer genreId;
        for(Movies m: movies) {
            if (m.getGenre()==null){genreId = null;}
            else{genreId = m.getGenre().getId();}

            moviesDTO.add(new MoviesDTO(m.getId(), m.getTitle(), m.getRating(), m.getAwards(), m.getRelease_date(), m.getLength(), genreId));
        }
        return moviesDTO;
    }

    @Override
    public List<MoviesDTO> getMoviesByGenreName(String name){
        List<Movies> movies = iMoviesRepository.findMoviesByGenre(name);
        List<MoviesDTO> moviesDTO = new ArrayList<>();
        Integer genreId;
        for(Movies m: movies) {
            if (m.getGenre()==null){genreId = null;}
            else{genreId = m.getGenre().getId();}

            moviesDTO.add(new MoviesDTO(m.getId(), m.getTitle(), m.getRating(), m.getAwards(), m.getRelease_date(), m.getLength(), genreId));
        }
        return moviesDTO;
    }
}
