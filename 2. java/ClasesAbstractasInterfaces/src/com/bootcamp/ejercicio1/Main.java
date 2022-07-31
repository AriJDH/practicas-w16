package com.bootcamp.ejercicio1;

import com.bootcamp.ejercicio1.modelos.Basic;
import com.bootcamp.ejercicio1.modelos.Colaborador;
import com.bootcamp.ejercicio1.modelos.Ejecutivo;

public class Main {
  public static void main(String[] args) {
    Ejecutivo usuarioEjecutivo = new Ejecutivo();
    Basic usuarioBasic = new Basic();
    Colaborador usuarioColaborador = new Colaborador();

    //Ejecutando los diferentes metodos de cada tipo de cliente
    usuarioEjecutivo.hacerTransferencia();
    usuarioEjecutivo.hacerDeposito();

    usuarioBasic.hacerConsulaDeSaldo();
    usuarioBasic.hacerPagoDeServicio();
    usuarioBasic.hacerRetiroDeEfectivo();

    usuarioColaborador.hacerConsulaDeSaldo();
    usuarioColaborador.hacerRetiroDeEfectivo();
  }
}
