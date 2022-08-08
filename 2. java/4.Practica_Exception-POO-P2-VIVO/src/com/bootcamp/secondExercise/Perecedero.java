package com.bootcamp.secondExercise;

public class Perecedero extends Product {
    private int diasPorCaducar;

    public Perecedero(String name, double price, int diasPorCaducar) {
        super(name, price);
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero() {
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public double calculate(int countProduts) {
        double result = (countProduts * getPrice());
        if (diasPorCaducar == 1) {
            result = (result * 0.4) - result;
        } else if (diasPorCaducar == 2) {
            result = (countProduts * getPrice());
            result = (result * 0.3) - result;
        } else if (diasPorCaducar == 3) {
            result = (countProduts * getPrice());
            result = (result * 0.5) - result;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
