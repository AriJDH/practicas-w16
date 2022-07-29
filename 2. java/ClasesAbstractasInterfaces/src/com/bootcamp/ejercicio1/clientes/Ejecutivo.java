package com.bootcamp.ejercicio1.clientes;

import com.bootcamp.ejercicio1.interfaces.Deposito;
import com.bootcamp.ejercicio1.interfaces.Ramdon;
import com.bootcamp.ejercicio1.interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
  @Override
  public void hacerDeposito() {
    System.out.println("Usuario Ejecutivo haciendo deposito");
    Integer ramdon = Ramdon.getRamdon();
    if (ramdon == 0) transaccionOk();
    if (ramdon == 1) transaccionNoOk();
  }

  @Override
  public void hacerTransferencia() {
    System.out.println("Usuario Ejecutivo haciendo transferencia");
    Integer ramdon = Ramdon.getRamdon();
    if (ramdon == 0) transaccionOk();
    if (ramdon == 1) transaccionNoOk();
  }

  @Override
  public void transaccionOk() {
    System.out.println("Transaccion exitosa.");
  }

  @Override
  public void transaccionNoOk() {
    System.out.println("Transaccion fallida.");
  }
}
