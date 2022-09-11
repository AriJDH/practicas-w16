package com.example.spring.hqlpractica.repository;

import com.example.spring.hqlpractica.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode,Long> {
    @Query("select e from Episode e join e.actors a where a.firstName = :firstName and a.lastName = :lastName")
    List<Episode> findByActorName(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
