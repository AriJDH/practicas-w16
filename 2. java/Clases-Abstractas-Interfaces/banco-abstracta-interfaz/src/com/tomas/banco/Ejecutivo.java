package com.tomas.banco;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 28 de Julio 2022
 */

import com.tomas.interfaces.Deposito;
import com.tomas.interfaces.Transaccion;
import com.tomas.interfaces.Transferencia;

public class Ejecutivo implements Transaccion, Deposito, Transferencia {

    //Sobreescritura del método depositar de la interfaz Deposito
    @Override
    public void depositar() {

        tipoCliente();
        System.out.println("Procesando depósito");
    }

    //Sobreescritura del método transaccionNoOk de la interfaz Transaccion
    @Override
    public void transaccionNoOk() {

        System.out.println("Transacción no finalizada");
        System.out.println("Ha ocurrido un error en la transacción");

    }

    //Sobreescritura del método transaccionOk de la interfaz Transaccion
    @Override
    public void transaccionOk() {

        System.out.println("Transacción exitosa");

    }

    //Sobreescritura del método transferir de la interfaz Transferencia
    @Override
    public void transferir() {

        tipoCliente();
        System.out.println("Procesando transferencia");


    }

    public void tipoCliente() {
        System.out.println("------------------");
        System.out.println("Cliente Ejecutivo");
        System.out.println("------------------");
    }

}
