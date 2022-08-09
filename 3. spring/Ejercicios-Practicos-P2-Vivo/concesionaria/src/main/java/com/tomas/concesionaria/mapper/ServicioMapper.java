package com.tomas.concesionaria.mapper;

import com.tomas.concesionaria.dto.ServicioDTO;
import com.tomas.concesionaria.entity.Servicio;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServicioMapper {

    public List<ServicioDTO> mapearServicioDTO(List<Servicio> listaServicio) {

        return listaServicio.stream().map(x->{
            ServicioDTO servicioDTO = new ServicioDTO();
            servicioDTO.setDate(x.getDate());
            servicioDTO.setDescriptions(x.getDescriptions());
            servicioDTO.setKilometers(x.getKilometers());

            return servicioDTO;

        }).collect(Collectors.toList());

    }


    public List<Servicio> mapearServicio(List<ServicioDTO> listaServicio){

       return listaServicio.stream().map(x->{
           Servicio servicio = new Servicio();
           servicio.setDate(x.getDate());
           servicio.setDescriptions(x.getDescriptions());
           servicio.setKilometers(x.getKilometers());

           return servicio;

       }).collect(Collectors.toList());

    }

}
