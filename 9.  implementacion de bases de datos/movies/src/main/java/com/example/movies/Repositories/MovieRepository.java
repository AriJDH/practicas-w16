package com.example.movies.Repositories;

import com.example.movies.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie AS m INNER JOIN m.actors AS a WHERE a.rating > :rating")
    List<Movie> findAllByActorRatingGreaterThan(@Param("rating") Double rating);
    List<Movie> findAllByGenre_Id(Long genreId);
}
