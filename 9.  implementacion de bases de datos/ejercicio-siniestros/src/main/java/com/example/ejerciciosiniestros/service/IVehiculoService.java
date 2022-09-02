package com.example.ejerciciosiniestros.service;

import com.example.ejerciciosiniestros.dto.PatenteMarcaDTO;
import com.example.ejerciciosiniestros.dto.PerdidasTotalDTO;
import com.example.ejerciciosiniestros.dto.VehiculoDTO;
import com.example.ejerciciosiniestros.dto.VehiculoPatenteDTO;
import com.example.ejerciciosiniestros.model.Vehiculo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoService {
    Vehiculo findVehiculoById(long id);

    Vehiculo saveVehiculo(Vehiculo vehiculo);

    void deleteVehiculo(long id);

    Vehiculo updateVehiculo(Vehiculo vehiculo);

    List<Vehiculo> findAllVehiculos();

    List<VehiculoPatenteDTO> getVehiculoPatentes();

    List<PatenteMarcaDTO> getPatenteMarcaOrderByAnio();

    List<VehiculoPatenteDTO> getPatenteAutosAnioActual();

    List<VehiculoDTO> getVehiculosPerdida();

    PerdidasTotalDTO getTotalPerdidas();
}
