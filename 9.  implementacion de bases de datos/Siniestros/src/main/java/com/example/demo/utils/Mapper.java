package com.example.demo.utils;

import com.example.demo.dto.GetMatriculaMarcaModeloAutoDTO;
import com.example.demo.dto.GetPatenteAutoDTO;
import com.example.demo.dto.GetPatenteMarcaAutoDTO;
import com.example.demo.model.Auto;

public class Mapper {

    public static GetPatenteAutoDTO toGetPatenteAutoDTO(Auto auto) {
        return new GetPatenteAutoDTO(auto.getPatente());
    }

    public static GetPatenteMarcaAutoDTO toGetPatenteMarcaAutoDTO(Auto auto) {
        return new GetPatenteMarcaAutoDTO(auto.getPatente(), auto.getMarca());
    }

    public static GetMatriculaMarcaModeloAutoDTO toGetMatriculaMarcaModeloAutoDTO(Auto auto) {
        return new GetMatriculaMarcaModeloAutoDTO(auto.getPatente(), auto.getMarca(), auto.getModelo());
    }

}
