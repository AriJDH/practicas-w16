package cl.morsecode.cl.dto;

import cl.morsecode.cl.entities.deportista.Deporte;
import cl.morsecode.cl.entities.deportista.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Persona_Deporte_DTO {
    private Persona persona;
    private Deporte deporte;
}
