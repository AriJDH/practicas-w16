package com.javaW16.joyeriaLasPerlas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Joya {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE) 
   Long id;
   Integer nroIdentificatorio;
   String nombre;
   String material;
   Double gramos;
   String particularidad;
   Boolean poseePiedra;
   Boolean ventas;

}
