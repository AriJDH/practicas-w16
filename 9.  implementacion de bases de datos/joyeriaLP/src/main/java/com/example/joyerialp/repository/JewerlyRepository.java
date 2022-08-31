package com.example.joyerialp.repository;

import com.example.joyerialp.model.Jewerly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewerlyRepository extends JpaRepository<Jewerly, Long> {

}
