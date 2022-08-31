package com.example.Joyeria.model;

import com.example.Joyeria.dto.JoyaDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nro_identificatorio;
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;

    public void update(JoyaDTO j){
        this.nombre = j.getNombre();
        this.material = j.getMaterial();
        this.peso = j.getPeso();
        this.particularidad = j.getParticularidad();
        this.posee_piedra = j.isPosee_piedra();
        this.ventaONo = j.isVentaONo();
    }
}
