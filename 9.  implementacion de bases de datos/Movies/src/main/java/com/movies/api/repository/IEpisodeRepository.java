package com.movies.api.repository;

import com.movies.api.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode,Long> {
}
