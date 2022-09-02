package com.example.hql.service;

import com.example.hql.dto.*;
import com.example.hql.model.Vehiculo;
import com.example.hql.model.VehiculoBD;

import java.util.List;

public interface ServiceVehiculo {
    String add(VehiculoDTO vehiculoDTO);
    VehiculoIdDTO getById(int id);
    List<VehiculoIdDTO> getAll();
    List<PatenteDTO> findPatenteAll();
    List<StringX2> findPatenteMarcaAll();

    List<StringX3> findPatenteMarcaModeloBySiniestroPerdida();
    List<VehiculoBDDTO> findPatenteMarcaModeloBySiniestroPerdidaTotal();


}
