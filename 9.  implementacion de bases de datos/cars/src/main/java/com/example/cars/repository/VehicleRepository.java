package com.example.cars.repository;

import com.example.cars.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findAllByOrderByYearOfProduction();

    @Query("select Vehicle as v from Vehicle join Sinister as s WHERE s.moneyLost > 10000")
    List<Vehicle> findAllBySinisterMoneyLost();
    @Query("select count(s.moneyLost) from Vehicle join Sinister as s WHERE s.moneyLost > 10000")
    List<Vehicle> CountAllBySinisterMoneyLost();
}
