package com.javaW16.empresaseguros.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Vehiculo
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class Vehiculo {
   
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   Long id;

   String patente;
   String marca;
   String modelo;
   Integer anioFabricacion;
   Integer cantidadDeRuedas;

   @OneToMany(mappedBy = "vehiculo")
   Set<Siniestro> siniestro;
   
}
