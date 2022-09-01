package com.javaW16.joyeriaLasPerlas.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.javaW16.joyeriaLasPerlas.dto.reqDTO.JoyaReqDTO;
import com.javaW16.joyeriaLasPerlas.dto.resDTO.JoyaResDTO;
import com.javaW16.joyeriaLasPerlas.model.Joya;

public class Mapper {

   public static Joya joyaDtoToEntity (JoyaReqDTO joyaReqDTO) {

      return Joya.builder()
      .nroIdentificatorio(joyaReqDTO.getNroIdentificatorio())
      .nombre(joyaReqDTO.getNombre())
      .material(joyaReqDTO.getMaterial())
      .gramos(joyaReqDTO.getGramos())
      .particularidad(joyaReqDTO.getParticularidad())
      .poseePiedra(joyaReqDTO.getPoseePiedra())
      .ventas(joyaReqDTO.getVentas())
      .build();   

   }

   public static JoyaResDTO joyaToJoyaResDto (Joya joya) {
      return JoyaResDTO.builder()
      .id(joya.getId())
      .nroIdentificatorio(joya.getNroIdentificatorio())
      .nombre(joya.getNombre())
      .material(joya.getMaterial())
      .gramos(joya.getGramos())
      .particularidad(joya.getParticularidad())
      .poseePiedra(joya.getPoseePiedra())
      .ventas(joya.getVentas())
      .build();
   }

   public static List<JoyaResDTO> joyaToListJoyaResDTO (List<Joya> listJoyas) {

      return listJoyas
         .stream()
         .map( Mapper::joyaToJoyaResDto)
         .collect(Collectors.toList())
      ;   

   }
}
