package com.example.ejerciciomovie.repository;

import com.example.ejerciciomovie.entity.Movie;
import com.example.ejerciciomovie.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository  extends JpaRepository<Movie,Long> {
}
