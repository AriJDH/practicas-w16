package com.bootcamp.ejercicio1.clientes;

public class Main {
  public static void main(String[] args) {
    Ejecutivo usuarioEjecutivo = new Ejecutivo();
    Basic usuarioBasic = new Basic();
    Colaborador usuarioColaborador = new Colaborador();

    usuarioEjecutivo.hacerTransferencia();
    usuarioEjecutivo.hacerDeposito();

    usuarioBasic.hacerConsulaDeSaldo();
    usuarioBasic.hacerPagoDeServicio();
    usuarioBasic.hacerRetiroDeEfectivo();

    usuarioColaborador.hacerConsulaDeSaldo();
    usuarioColaborador.hacerRetiroDeEfectivo();
  }
}
