package com.tomas.joyeria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaActualizadoDTO extends ListaJoyaDTO {

    @JsonProperty("codigo_estado")
    private int codigoEstado;
    private String mensaje;

}
