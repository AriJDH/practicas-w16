package practica.clasesabstractaseinterfaces.ejercicio1.clientes;

import practica.clasesabstractaseinterfaces.ejercicio1.transacciones.ConsultaSaldo;
import practica.clasesabstractaseinterfaces.ejercicio1.transacciones.PagoServicios;
import practica.clasesabstractaseinterfaces.ejercicio1.transacciones.RetiroEfectivo;

public class Basic extends Cliente {

    PagoServicios pagoServicios;

    public Basic(RetiroEfectivo retiroEfectivo, ConsultaSaldo consultaSaldo, PagoServicios pagoServicios) {
        super(retiroEfectivo, consultaSaldo);
        this.pagoServicios = pagoServicios;
    }
}
