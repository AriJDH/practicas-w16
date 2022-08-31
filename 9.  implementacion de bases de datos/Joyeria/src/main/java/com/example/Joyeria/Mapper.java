package com.example.Joyeria;

import com.example.Joyeria.dto.JoyaDTO;
import com.example.Joyeria.model.Joya;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public JoyaDTO toDTO(Joya j){
        return new JoyaDTO(
                j.getNro_identificatorio(),
                j.getNombre(),
                j.getMaterial(),
                j.getPeso(),
                j.getParticularidad(),
                j.isPosee_piedra(),
                j.isVentaONo()
        );
    }
}
