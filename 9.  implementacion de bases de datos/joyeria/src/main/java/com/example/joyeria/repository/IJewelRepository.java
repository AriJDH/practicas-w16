package com.example.joyeria.repository;

import com.example.joyeria.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJewelRepository extends JpaRepository<Jewel, Long> {
    List<Jewel> findAllByIsSold(Boolean isSold);
}
