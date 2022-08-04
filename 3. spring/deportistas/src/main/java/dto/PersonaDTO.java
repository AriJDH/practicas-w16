package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO implements Serializable {

    private String nombre;
    private String apellido;
    private Integer edad;
}
