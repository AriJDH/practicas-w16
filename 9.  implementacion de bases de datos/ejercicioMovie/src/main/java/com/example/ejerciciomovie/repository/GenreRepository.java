package com.example.ejerciciomovie.repository;

import com.example.ejerciciomovie.entity.Genre;
import com.example.ejerciciomovie.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository  extends JpaRepository<Genre,Long> {
}
