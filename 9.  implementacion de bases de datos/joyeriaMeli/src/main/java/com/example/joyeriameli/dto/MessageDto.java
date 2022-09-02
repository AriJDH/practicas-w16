package com.example.joyeriameli.dto;

import com.example.joyeriameli.model.Joya;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private String message;
    private Long Nro_identificatorio;
    private Joya joya;

    public MessageDto(String message, Joya joya) {
        this.message = message;
        this.joya = joya;
    }

    public MessageDto(String message, Long nro_identificatorio) {
        this.message = message;
        Nro_identificatorio = nro_identificatorio;
    }

    public MessageDto(String message) {
        this.message = message;
    }
}
