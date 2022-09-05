package com.meli.seguro.repository;

import com.meli.seguro.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ISiniestroRepository extends JpaRepository<Siniestro,Integer> {



}
