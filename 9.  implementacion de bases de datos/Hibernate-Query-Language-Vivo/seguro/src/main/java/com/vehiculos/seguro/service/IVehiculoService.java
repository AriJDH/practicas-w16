package com.vehiculos.seguro.service;

import com.vehiculos.seguro.dto.PatenteModeloMarcaDTO;
import com.vehiculos.seguro.dto.VehiculoPatenteDTO;
import com.vehiculos.seguro.dto.VehiculoPatenteMarcaDTO;
import com.vehiculos.seguro.dto.VehiculoTotalPerdidaDTO;

import java.util.List;

public interface IVehiculoService {
    List<VehiculoPatenteDTO>  listAllByPatente();
    List<VehiculoPatenteMarcaDTO> listPatenteMarca();
    List<VehiculoPatenteDTO> listVehiculoCuatroRuedas();
    List<PatenteModeloMarcaDTO> listVehiculoSienietroMayorDiezmil();
    List<VehiculoTotalPerdidaDTO> listVehiculoSiniestroMayorDiezmilSumatoriaTotal();
}
