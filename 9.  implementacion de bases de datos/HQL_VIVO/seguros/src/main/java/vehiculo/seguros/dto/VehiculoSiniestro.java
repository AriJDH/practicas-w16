package vehiculo.seguros.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vehiculo.seguros.model.Vehiculo;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoSiniestro {
    List<Vehiculo_Marca_ModeloDTO> vehiculo;
    Integer perdida_total;

}
