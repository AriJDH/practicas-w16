package com.example.movieshql.repository;

import com.example.movieshql.model.Episode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IEpisodeRepository extends CrudRepository<Episode,Integer> {

    @Query("SELECT e FROM Episode e JOIN e.actors actor WHERE actor.firstName=:firstName AND actor.lastName=:lastName")
    List<Episode> findEpisodeByActor(@Param ("firstName") String firstName, @Param("lastName")String lastName);
}
