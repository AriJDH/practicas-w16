package com.bootcamp.demo.repository;

import com.bootcamp.demo.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT patente FROM Vehiculo")
    String[] getPatentes();
}
