package com.bootcamp.movieshql.repository;

import com.bootcamp.movieshql.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenreRepository extends JpaRepository<Genre, Integer> {
}
