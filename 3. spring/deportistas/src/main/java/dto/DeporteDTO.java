package dto;

import entities.Deporte;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DeporteDTO implements Serializable {

    private String nombre;
    private String nivel;

}
