package vehiculo.seguros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    LocalDate fecha_siniestro;
    Integer perdida_economica;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "id_vehiculo")
    Vehiculo vehículo_denunciado;
}
