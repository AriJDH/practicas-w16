package com.joyeria.lasperlas.repository;

import com.joyeria.lasperlas.Entity.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoyaDAO extends JpaRepository<Joya, Long> {
}
