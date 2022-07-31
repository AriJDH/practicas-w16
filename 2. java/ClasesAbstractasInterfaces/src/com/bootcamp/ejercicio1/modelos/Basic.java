package com.bootcamp.ejercicio1.modelos;

import com.bootcamp.ejercicio1.interfaces.ConsultarSaldo;
import com.bootcamp.ejercicio1.interfaces.PagoDeServicio;
import com.bootcamp.ejercicio1.interfaces.Ramdon;
import com.bootcamp.ejercicio1.interfaces.RetiroDeEfectivo;

public class Basic implements ConsultarSaldo, PagoDeServicio, RetiroDeEfectivo {
  @Override
  public void hacerConsulaDeSaldo() {
    System.out.println("Usuario basic consultando saldo");
    Integer ramdon = Ramdon.getRamdon();
    if (ramdon == 0) transaccionOk();
    if (ramdon == 1) transaccionNoOk();
  }

  @Override
  public void hacerPagoDeServicio() {
    System.out.println("Usuario basic haciendo pago de servicio");
    Integer ramdon = Ramdon.getRamdon();
    if (ramdon == 0) transaccionOk();
    if (ramdon == 1) transaccionNoOk();
  }

  @Override
  public void hacerRetiroDeEfectivo() {
    System.out.println("Usuario basic haciendo retiro de efectivo");
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
