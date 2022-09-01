package com.bootcamp.movies.dto;

import com.bootcamp.movies.model.Movie;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

public class ActorDTO {

    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String firstName;
    private String lastName;
    private Integer rating;
    private Movie favoriteMovie;

    public ActorDTO(String firstName, String lastName, Movie favoriteMovie) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteMovie = favoriteMovie;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Movie getFavoriteMovie() {
        return favoriteMovie;
    }

    public void setFavoriteMovie(Movie favoriteMovie) {
        this.favoriteMovie = favoriteMovie;
    }
}
