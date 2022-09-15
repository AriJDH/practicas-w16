package com.example.movies.Services;

import com.example.movies.DTO.MovieDto;
import com.example.movies.Repositories.MovieRepository;
import com.example.movies.Utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<MovieDto> findAllByActorRatingGreaterThan(Double rating) {
        return Mapper.listMapMovieDto(this.movieRepository.findAllByActorRatingGreaterThan(rating));
    }
    public List<MovieDto> findAllByGenreId(Long genreId) {
        return Mapper.listMapMovieDto(this.movieRepository.findAllByGenre_Id(genreId));
    }
}
