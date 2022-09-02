package com.tomas.movieshql.service;

import com.tomas.movieshql.dto.ListActorDTO;
import com.tomas.movieshql.dto.ListEpisodeDTO;
import com.tomas.movieshql.dto.ListMovieDTO;
import com.tomas.movieshql.dto.ListSerieDTO;

public interface IMovieService {

    ListActorDTO searchActorFavoriteMovie();
    ListActorDTO searchActorRating(float rating);
    ListActorDTO searchActorMovie(String nameMovie);
    ListMovieDTO searchMovieRatingActor(float rating);
    ListMovieDTO searchMovieByGenre(String nameGenre);
    ListSerieDTO searchSerieWithMaxSeason(int amountSeason);
    ListEpisodeDTO searchEpisodeByActor(String firstName, String lastName);

}
