package com.tomas.distribuidora;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 27 de Julio 2022
 */

public class Perecedero extends Producto {

    private int diasPorCaducar;

    //Constructor que hereda atributos de la clase Producto
    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    //Métodos getter and setter

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    //Método sobreescrito de la clase producto
    @Override
    public double calcular(int cantidadDeProductos) {

        float valor = (float)super.calcular(cantidadDeProductos);
        if(diasPorCaducar == 1) {
            valor = valor/4;
        } else if(diasPorCaducar == 2) {
            valor = valor/3;
        } else if(diasPorCaducar == 3) {
            valor = valor/2;
        }

        return valor;

    }
}
