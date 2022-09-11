package com.example.spring.joyeria.repository;

import com.example.spring.joyeria.entity.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelRepository extends JpaRepository<Jewel, Long> {
}
