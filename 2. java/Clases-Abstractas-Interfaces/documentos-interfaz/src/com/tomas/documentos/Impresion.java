package com.tomas.documentos;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 28 de Julio 2022
 */

public interface Impresion {

    static void imprimir(Impresion dato){

        dato.imprimir();

    }

    void imprimir();

}
