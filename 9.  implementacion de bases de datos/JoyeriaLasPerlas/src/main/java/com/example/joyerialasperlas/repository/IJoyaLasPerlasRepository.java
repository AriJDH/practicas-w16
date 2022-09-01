package com.example.joyerialasperlas.repository;

import com.example.joyerialasperlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaLasPerlasRepository extends JpaRepository<Joya, Long> {
}
