package com.ndemaio.ejerciciojoyeria.repository;

import com.ndemaio.ejerciciojoyeria.model.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JewelryRepository extends JpaRepository<Jewelry, Integer> {
}
