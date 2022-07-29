package practica.clasesabstractaseinterfaces.ejercicio1.clientes;

import practica.clasesabstractaseinterfaces.ejercicio1.transacciones.ConsultaSaldo;
import practica.clasesabstractaseinterfaces.ejercicio1.transacciones.RetiroEfectivo;

public class Cobrador extends Cliente {

    public Cobrador(RetiroEfectivo retiroEfectivo, ConsultaSaldo consultaSaldo) {
        super(retiroEfectivo, consultaSaldo);
    }
}
