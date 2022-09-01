package com.bootcamp.lasperlas.repository;

import com.bootcamp.lasperlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaRepository extends JpaRepository<Joya, Long> {

}
