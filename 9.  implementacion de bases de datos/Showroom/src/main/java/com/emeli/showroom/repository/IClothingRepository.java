package com.emeli.showroom.repository;

import com.emeli.showroom.entity.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothingRepository extends JpaRepository<Clothing, String> {
    List<Clothing> findBySize(String size);
    List<Clothing> findByName(String name);
}
