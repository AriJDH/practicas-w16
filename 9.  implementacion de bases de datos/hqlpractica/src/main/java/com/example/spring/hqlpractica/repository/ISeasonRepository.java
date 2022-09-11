package com.example.spring.hqlpractica.repository;

import com.example.spring.hqlpractica.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeasonRepository extends JpaRepository<Season,Long> {
}
