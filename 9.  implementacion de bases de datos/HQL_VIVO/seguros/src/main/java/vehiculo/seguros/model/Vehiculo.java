package vehiculo.seguros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter

public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String patente;
    String marca;
    String modelo;
    Integer year_fabricacion;
    Integer ruedas;

    @OneToMany(mappedBy = "vehículo_denunciado")
    private Set<Siniestro> siniestro;
}
