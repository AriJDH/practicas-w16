package com.javaW16.empresaseguros.service;

import java.util.List;

import com.javaW16.empresaseguros.dto.resDTO.VehiculoPatenteMarcaModeloResDTO;
import com.javaW16.empresaseguros.dto.resDTO.VehiculoPatenteMarcaResDTO;
import com.javaW16.empresaseguros.dto.resDTO.VehiculoSiniestro;
import com.javaW16.empresaseguros.model.Vehiculo;
import com.javaW16.empresaseguros.repository.IVehiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ImpService
 */

@Service
public class ImpService implements IService {


   @Autowired
   IVehiculoRepository vehiculosRepository;

   @Override
   public List<String> listAllPatentes() {
      return vehiculosRepository.listAllPatentes();
   }

   @Override
   public List<VehiculoPatenteMarcaResDTO> listAllPatentesAndMarcaByAnio() {

      return vehiculosRepository.listAllPatentesAndMarcaByAnio();
   }

   @Override
   public List<String> listAllPatentesOfAllVehiculosWithFourOrMoreRuedas (Integer anioFabricacion) {
      return vehiculosRepository.listAllPatentesOfAllVehiculosWithFourOrMoreRuedas (anioFabricacion);   
   }

   @Override
   public List<VehiculoPatenteMarcaModeloResDTO> listAllVehiculosWithSiniestroGreaterThan() {
      return vehiculosRepository.listAllVehiculosWithSiniestroGreaterThan();
   }

   @Override
   	public VehiculoSiniestro listVehiculoSiniestros() {
      	 return new  VehiculoSiniestro(vehiculosRepository.listAllVehiculosWithSiniestroGreaterThan(),vehiculosRepository.sumaPerdidaTotal()) ;
   	}


}
