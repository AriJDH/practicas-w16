package com.vehiculos.seguro.service;

import com.vehiculos.seguro.dto.PatenteModeloMarcaDTO;
import com.vehiculos.seguro.dto.VehiculoPatenteDTO;
import com.vehiculos.seguro.dto.VehiculoPatenteMarcaDTO;
import com.vehiculos.seguro.dto.VehiculoTotalPerdidaDTO;
import com.vehiculos.seguro.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService{

    @Autowired
    IVehiculoRepository vehiculoRepository;

    @Override
    public List<VehiculoPatenteDTO> listAllByPatente() {
        return vehiculoRepository.findAllByPatente().stream()
                .map( v -> new VehiculoPatenteDTO(v.getPatente()))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoPatenteMarcaDTO> listPatenteMarca() {
        return vehiculoRepository.findAllOrderByAnioFabricacion().stream()
                .map( v -> new VehiculoPatenteMarcaDTO(v.getPatente(), v.getMarca()))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoPatenteDTO> listVehiculoCuatroRuedas() {
        return vehiculoRepository.findAllWith4WheelsMadeThisYear().stream()
                .map( v -> new VehiculoPatenteDTO(v.getPatente()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PatenteModeloMarcaDTO> listVehiculoSienietroMayorDiezmil() {
        return vehiculoRepository.findAllVehiculosWithPerdidaEconomicaMayorDiezmil().stream()
                .map( v -> new PatenteModeloMarcaDTO(v.getPatente(), v.getMarca(), v.getModelo()))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoTotalPerdidaDTO> listVehiculoSiniestroMayorDiezmilSumatoriaTotal() {

        return vehiculoRepository.findAllVehiculosWithPerdidaEconomicaMayorDiezmil().stream()
                .map( v -> {

                    VehiculoTotalPerdidaDTO vehiculoTotalPerdidaDTO = new VehiculoTotalPerdidaDTO();
                    vehiculoTotalPerdidaDTO.setPatente(v.getPatente());
                    vehiculoTotalPerdidaDTO.setMarca(v.getMarca());
                    vehiculoTotalPerdidaDTO.setModelo(v.getModelo());
                    vehiculoTotalPerdidaDTO.setPerdidaTotal(v.getSiniestros().stream().mapToDouble(y->y.getPerdidaEconomica()).sum());

                    return vehiculoTotalPerdidaDTO;

                }).collect(Collectors.toList());
    }


}
