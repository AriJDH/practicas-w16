package com.bootcamp.lasperlas.model;

import lombok.*;

import javax.annotation.PostConstruct;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "joya")
public class Joya {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "nro_identificatorio")
  private Long nroIdentificatorio;
  @Column(name = "nombre")
  private String nombre;
  @Column(name = "material")
  private String material;
  @Column(name = "peso")
  private Double peso;
  @Column(name = "particularidad")
  private String particularidad;
  @Column(name = "posee_piedra")
  private Boolean poseePiedra;
  @Column(name = "venta_o_no")
  private Boolean venta;

}
