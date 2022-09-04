package com.bootcamp.movieshql.repository;

import com.bootcamp.movieshql.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeasonRepository extends JpaRepository<Season, Integer> {
}
