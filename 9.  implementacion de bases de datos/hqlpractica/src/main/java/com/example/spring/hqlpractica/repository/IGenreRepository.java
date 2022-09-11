package com.example.spring.hqlpractica.repository;

import com.example.spring.hqlpractica.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenreRepository extends JpaRepository<Genre,Long> {
}
