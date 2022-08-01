package com.main;

import com.banco.Basic;
import com.banco.Cobrador;
import com.banco.Ejecutivo;

public class Main {

    public static void main(String[] args) {
        Basic objBasic = new Basic(23000);
        Cobrador objCobrador = new Cobrador(32000);
        Ejecutivo objEjecutivo = new Ejecutivo(54000);

        objBasic.ConsultaSaldos();
        objBasic.PagoServicio();
        objBasic.RetiroEfectivo();

        objCobrador.ConsultaSaldos();
        objCobrador.RetiroEfectivo();

        objEjecutivo.Deposito();
        objEjecutivo.Trasferencia();

    }

}
