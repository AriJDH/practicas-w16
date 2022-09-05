package com.bootcamp.showroom.repository;

import com.bootcamp.showroom.entity.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IClothesRepository extends JpaRepository<Clothes,Long> {
    Optional<Clothes> findByCode(String code);
    List<Clothes> findBySize(String size);
}
