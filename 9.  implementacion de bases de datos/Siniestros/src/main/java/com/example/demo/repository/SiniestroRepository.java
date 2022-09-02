package com.example.demo.repository;

import com.example.demo.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiniestroRepository extends JpaRepository<Siniestro, Long> {
}
