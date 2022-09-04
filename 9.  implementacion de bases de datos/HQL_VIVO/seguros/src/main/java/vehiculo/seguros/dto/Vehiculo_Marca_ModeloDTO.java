package vehiculo.seguros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo_Marca_ModeloDTO {
    String patente;
    String marca;
    String modelo;
}
