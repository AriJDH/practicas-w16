package com.emeli.showroom.repository;

import com.emeli.showroom.entity.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothingRepository extends JpaRepository<Clothing, Long> {
    List<Clothing> findBySize(String size);
    @Query("SELECT c FROM Clothing c WHERE c.name LIKE %:name%")
    List<Clothing> findByName(@Param("name") String name);
}
