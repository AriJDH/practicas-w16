package com.tomas.movieshql.repository;

import com.tomas.movieshql.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode, Long> {

    @Query("select e from Episode e join e.actors a where a.firstName = :first_name and a.lastName = :last_name")
    Set<Episode> findEpisodeByActor(@Param("first_name") String firstName, @Param("last_name") String lastName);

}
