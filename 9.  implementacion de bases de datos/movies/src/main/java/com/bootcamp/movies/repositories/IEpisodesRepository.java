package com.bootcamp.movies.repositories;

import com.bootcamp.movies.models.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEpisodesRepository extends JpaRepository<Episode,Long> {
}
