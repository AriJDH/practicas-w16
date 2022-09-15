package com.example.cars.repository;

import com.example.cars.model.Sinister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinisterRepository extends JpaRepository<Sinister, Long> {
}
