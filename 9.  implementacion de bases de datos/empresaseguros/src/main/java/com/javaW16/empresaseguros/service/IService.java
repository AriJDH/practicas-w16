package com.javaW16.empresaseguros.service;

import java.util.List;

import com.javaW16.empresaseguros.dto.resDTO.VehiculoPatenteMarcaModeloResDTO;
import com.javaW16.empresaseguros.dto.resDTO.VehiculoPatenteMarcaResDTO;
import com.javaW16.empresaseguros.dto.resDTO.VehiculoSiniestro;

import org.springframework.stereotype.Service;

/**
 * IService
 */

public interface IService {

   List<String> listAllPatentes ();

   List<VehiculoPatenteMarcaResDTO> listAllPatentesAndMarcaByAnio ();

   List<String> listAllPatentesOfAllVehiculosWithFourOrMoreRuedas (Integer anioFabricacion);   

   List<VehiculoPatenteMarcaModeloResDTO> listAllVehiculosWithSiniestroGreaterThan ();   
   
   VehiculoSiniestro listVehiculoSiniestros ();

}
