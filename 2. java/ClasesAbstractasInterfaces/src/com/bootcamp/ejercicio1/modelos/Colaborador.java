package com.bootcamp.ejercicio1.modelos;

import com.bootcamp.ejercicio1.interfaces.ConsultarSaldo;
import com.bootcamp.ejercicio1.interfaces.Ramdon;
import com.bootcamp.ejercicio1.interfaces.RetiroDeEfectivo;

public class Colaborador implements RetiroDeEfectivo, ConsultarSaldo {
  @Override
  public void hacerRetiroDeEfectivo() {
    System.out.println("Usuario Colaborador haciendo retiro en efectivo");
    Integer ramdon = Ramdon.getRamdon();
    if (ramdon == 0) transaccionOk();
    if (ramdon == 1) transaccionNoOk();
  }

  @Override
  public void hacerConsulaDeSaldo() {
    System.out.println("Usuario Colaborador haciendo consulta de saldo");
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
