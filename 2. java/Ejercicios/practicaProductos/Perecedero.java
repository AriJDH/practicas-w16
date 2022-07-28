package com.bootcamp.practicaProductos;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(int diasPorCaducar, String nombre, double precio) {
       super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;

    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }


    @Override
    public Double calcular(int cantidadDeProductos){
        Double precioAuxiliar = this.getPrecio() * cantidadDeProductos;
        if(this.diasPorCaducar == 3) return precioAuxiliar/2;
        if(this.diasPorCaducar == 2) return precioAuxiliar/3;
        if(this.diasPorCaducar == 1) return precioAuxiliar/4;
        return precioAuxiliar;
    }
}
