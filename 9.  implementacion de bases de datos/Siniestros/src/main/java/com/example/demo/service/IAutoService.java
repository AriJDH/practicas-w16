package com.example.demo.service;

import com.example.demo.dto.GetMatriculaMarcaModeloAutoDTO;
import com.example.demo.dto.GetPatenteAutoDTO;
import com.example.demo.dto.GetPatenteMarcaAutoDTO;

import java.util.List;

public interface IAutoService {
    GetPatenteAutoDTO getPatenteAuto(Long id);
    List<GetPatenteAutoDTO> getPatentes();
    List<GetPatenteMarcaAutoDTO> getPatenteMarcaOrderByAnioFabricacion();
    List<GetMatriculaMarcaModeloAutoDTO> getPatenteMarcaModeloWithSiniestro();

}
