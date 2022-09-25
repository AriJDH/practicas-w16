package com.relaciones.jpa.entities.clavesCompuestas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "compra")
@IdClass(value = CompraKey.class)
public class Compra {

    @Id
    @Column(name = "id")
    private Long clienteId;
    @Id
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "modo_de_envio")
    private String modoDeEnvio;

}
