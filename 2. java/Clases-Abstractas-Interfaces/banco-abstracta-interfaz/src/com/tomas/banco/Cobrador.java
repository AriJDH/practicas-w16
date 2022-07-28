package com.tomas.banco;

/**
 * Desarrollador: Tomas Octavio Rodriguez Herrera
 * Fecha: 28 de Julio 2022
 */

import com.tomas.interfaces.ConsultaSaldo;
import com.tomas.interfaces.RetiroEfectivo;
import com.tomas.interfaces.Transaccion;

public class Cobrador implements Transaccion, RetiroEfectivo, ConsultaSaldo {

    //Sobreescritura del método consultar de la interfaz ConsultaSaldo
    @Override
    public void consultar() {

        tipoCliente();
        System.out.println("Procesando consulta de saldo");
    }

    //Sobreescritura del método retirar de la interfaz RetiroEfectivo
    @Override
    public void retirar() {

        tipoCliente();
        System.out.println("Procesando retiro en efectivo");

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

    public void tipoCliente() {
        System.out.println("------------------");
        System.out.println("Cliente Cobrador");
        System.out.println("------------------");
    }
}
