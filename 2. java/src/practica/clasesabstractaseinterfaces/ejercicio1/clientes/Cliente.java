package practica.clasesabstractaseinterfaces.ejercicio1.clientes;

import practica.clasesabstractaseinterfaces.ejercicio1.transacciones.ConsultaSaldo;
import practica.clasesabstractaseinterfaces.ejercicio1.transacciones.RetiroEfectivo;

public class Cliente {
    RetiroEfectivo retiroEfectivo;
    ConsultaSaldo consultaSaldo;

    public Cliente(RetiroEfectivo retiroEfectivo, ConsultaSaldo consultaSaldo) {
        this.retiroEfectivo = retiroEfectivo;
        this.consultaSaldo = consultaSaldo;
    }
}
