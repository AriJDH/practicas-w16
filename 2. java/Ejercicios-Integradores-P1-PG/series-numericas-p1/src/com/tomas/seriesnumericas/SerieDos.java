package com.tomas.seriesnumericas;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 01 de Agosto 2022
 */

public class SerieDos extends Prototipo{

    private int numero;

    //Constructor
    public SerieDos(){
        this.reiniciarSerie();

    }

    //Métodos getter y setter
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    //Método sobreescrito de la clase Prototipo
    @Override
    public int devolverNumero() {

        int numero = this.numero + 2;
        this.establecerValor(numero);
        return numero;
    }

    //Método sobreescrito de la clase Prototipo
    @Override
    public void reiniciarSerie() {
        this.numero = 0;
    }

    //Método sobreescrito de la clase Prototipo
    @Override
    public void establecerValor(int numero) {
        this.numero = numero;
    }
}
