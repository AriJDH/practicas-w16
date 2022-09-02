package com.bootcamp.empresaseguroshql.service;

import com.bootcamp.empresaseguroshql.dto.VehiculoPatenteDto;
import com.bootcamp.empresaseguroshql.dto.VehiculoPatenteMarcaDto;
import com.bootcamp.empresaseguroshql.dto.VehiculoPatenteMarcaModeloDto;
import com.bootcamp.empresaseguroshql.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService {

    @Autowired
    IVehiculoRepository iVehiculoRepository;

    @Override
    public List<VehiculoPatenteDto> encontrarPatenteVehiculos() {
        return iVehiculoRepository.encontrarPatenteVehiculos().stream().map(VehiculoPatenteDto::new).collect(Collectors.toList());
    }

    @Override
    public List<VehiculoPatenteMarcaDto> encontrarPatenteMarcaVehiculos() {
        return iVehiculoRepository.encontrarPatenteMarcaVehiculos().stream()
                .map(s -> new VehiculoPatenteMarcaDto(s.get("patente"), s.get("marca")))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoPatenteDto> encontrarVehiculoMas4RuedasAnioEnCurso() {
        return iVehiculoRepository.encontrarVehiculoMas4RuedasAnioEnCurso().stream().map(VehiculoPatenteDto::new).collect(Collectors.toList());
    }

    @Override
    public List<VehiculoPatenteMarcaModeloDto> encontrarVehiculosPerdidaMayor10000() {
        return iVehiculoRepository.encontrarVehiculosPerdidaMayor10000().stream()
                .map(s -> new VehiculoPatenteMarcaModeloDto(s.get("patente"), s.get("marca"), s.get("modelo")))
                .collect(Collectors.toList());
    }
}
