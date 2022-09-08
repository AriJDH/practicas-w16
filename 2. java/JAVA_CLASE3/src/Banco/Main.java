package Banco;

import Banco.Modelos.Basic;
import Banco.Modelos.Cobradores;
import Banco.Modelos.Ejecutivos;

public class Main {
    public static void main(String[] args) {
        Ejecutivos usuarioEjecutivo = new Ejecutivos();
        Basic usuarioBasic = new Basic();
        Cobradores usuarioCobrador = new Cobradores();

        //Ejecutando los diferentes metodos de cada tipo de cliente
        usuarioEjecutivo.hacerTransferencia();
        usuarioEjecutivo.hacerDeposito();

        usuarioBasic.hacerConsulta();
        usuarioBasic.hacerPagoServicios();
        usuarioBasic.hacerRetiroEfectivo();

        usuarioCobrador.hacerConsulta();
        usuarioCobrador.hacerRetiroEfectivo();
    }

}
