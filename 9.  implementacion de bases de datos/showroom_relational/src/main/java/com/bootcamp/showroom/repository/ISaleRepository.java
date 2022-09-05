package com.bootcamp.showroom.repository;

import com.bootcamp.showroom.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ISaleRepository extends JpaRepository<Sale,Long> {
    Optional<Sale> findByNumber(Long number);
}
