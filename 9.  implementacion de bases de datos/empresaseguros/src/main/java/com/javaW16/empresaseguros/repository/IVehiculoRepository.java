package com.javaW16.empresaseguros.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import com.javaW16.empresaseguros.dto.resDTO.VehiculoPatenteMarcaModeloResDTO;
import com.javaW16.empresaseguros.dto.resDTO.VehiculoPatenteMarcaResDTO;
import com.javaW16.empresaseguros.model.Vehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * IVehiculoRepository
 */

@Repository
public interface IVehiculoRepository extends JpaRepository <Vehiculo, Long> {

   @Query("select v.patente from Vehiculo v")
   List<String> listAllPatentes ();

   @Query("select new com.javaW16.empresaseguros.dto.resDTO.VehiculoPatenteMarcaResDTO(v.patente, v.marca) from Vehiculo v order by v.anioFabricacion")
   List<VehiculoPatenteMarcaResDTO> listAllPatentesAndMarcaByAnio ();

   @Query("select v.patente from Vehiculo v where v.cantidadDeRuedas > 4 and v.anioFabricacion = :anioFabricacion")
   List<String> listAllPatentesOfAllVehiculosWithFourOrMoreRuedas (@Param("anioFabricacion") Integer anioFabricacion);   

   @Query("select new com.javaW16.empresaseguros.dto.resDTO.VehiculoPatenteMarcaModeloResDTO(v.patente, v.marca, v.modelo) from Vehiculo v inner join v.siniestro s where s.perdidaEconomica > 10000 group by v.patente, v.marca, v.modelo ")
   List<VehiculoPatenteMarcaModeloResDTO> listAllVehiculosWithSiniestroGreaterThan ();
   
   @Query("select sum(s.perdidaEconomica) from Vehiculo v inner join v.siniestro s where s.perdidaEconomica > 10000 ")
   Integer sumaPerdidaTotal ();
   
}
