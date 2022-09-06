package com.example.lasPerlas.util;

import com.example.lasPerlas.dto.JoyaDTO;
import com.example.lasPerlas.entity.Joya;

public class Mapper {

    public static Joya mapperJoyaDTOtoJoya(JoyaDTO joyaDTO){
        return Joya.builder()
                .nombre(joyaDTO.getNombre())
                .material(joyaDTO.getMaterial())
                .peso(joyaDTO.getPeso())
                .particularidad(joyaDTO.getParticularidad())
                .posee_piedra(joyaDTO.isPosee_piedra())
                .ventaONo(joyaDTO.isVentaONo())
                .build();
    }
    public static Joya mapperJoyaDTOtoJoyaWithId(JoyaDTO joyaDTO){
        return Joya.builder()
                .nro_identificatorio(joyaDTO.getNro_identificatorio())
                .nombre(joyaDTO.getNombre())
                .material(joyaDTO.getMaterial())
                .peso(joyaDTO.getPeso())
                .particularidad(joyaDTO.getParticularidad())
                .posee_piedra(joyaDTO.isPosee_piedra())
                .ventaONo(joyaDTO.isVentaONo())
                .build();
    }

    public static JoyaDTO mapperJoyatoJoyaDto(Joya joya){
        return JoyaDTO.builder()
                .nro_identificatorio(joya.getNro_identificatorio())
                .nombre(joya.getNombre())
                .material(joya.getMaterial())
                .peso(joya.getPeso())
                .particularidad(joya.getParticularidad())
                .posee_piedra(joya.isPosee_piedra())
                .ventaONo(joya.isVentaONo())
                .build();
    }
}
