package com.bootcamp.twoExercise;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(){

    }

    public Perecedero(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public double calcular(int cantidadDeProductos) {
        double resultado = (cantidadDeProductos * getPrecio());
        if (diasPorCaducar == 1){
            resultado = (resultado*0.4)-resultado;
        } else if (diasPorCaducar == 2) {
            resultado = (resultado*0.3)-resultado;
        } else if (diasPorCaducar == 3) {
            resultado = (resultado*0.5)-resultado;
        }

        return resultado;
    }


    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
