package com.movies.movies.repository;

import com.movies.movies.model.Episodes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodesRepository extends CrudRepository<Episodes,Integer> {

    @Query("SELECT e FROM Episodes e INNER JOIN e.actors actors WHERE actors.first_name LIKE :name%")
    List<Episodes> getEpisodesByActorName(@Param("name") String name);
}
