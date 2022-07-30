package Ejercicio1.Clases;

import Ejercicio1.Interfaces.Deposito;
import Ejercicio1.Interfaces.Transacciones;

public class Ejecutivos implements  Deposito {
    @Override
   public void transaccionOk(){
       System.out.println("Transaccion OK");
   }
   @Override
    public void transaccionNoOk(){
        System.out.println("Transaccion OK");
    }

    @Override
    public void realizarDeposito() {
        System.out.println("Realizando deposito");
    }
}
