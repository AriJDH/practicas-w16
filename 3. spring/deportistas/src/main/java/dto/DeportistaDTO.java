package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeportistaDTO implements Serializable {

    private String nombre;
    private String Apellido;
    private String deporte;
}
