package com.bootcamp.demo.repository;

import com.bootcamp.demo.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelRepository extends JpaRepository <Jewel, Long> {
    
}
