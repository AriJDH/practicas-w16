package com.example.lasPerlas.repository;

import com.example.lasPerlas.entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyeriaRepository extends JpaRepository<Joya,Long> {
}
