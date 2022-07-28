package   ExerciseOne.actors;

import   ExerciseOne.interfaces.*;
import   ExerciseOne.utils.Timer;

public class Ejecutivo implements Deposito, Transferencia{

    @Override
    public void hacerDeposito(){
        String tipo = "Deposito";

        System.out.println("Realizando deposito...");
        Timer.run();

        if(Timer.getState()) transaccionOK(tipo);
        else transaccionNoOK(tipo);
    }

    @Override
    public void transaccionNoOK(String tipoTransaccion){
        System.out.println("La transaccion - " + tipoTransaccion + " no se ha realizado.");
    }

    @Override 
    public void transaccionOK(String tipoTransaccion){
        System.out.println("La transaccion - " + tipoTransaccion + " se ha realizado con exito.");
    }

    @Override
    public void hacerTransferencia(){
        String tipo = "Transferencia";

        System.out.println("Realizando transferencia...");
        Timer.run();

        if(Timer.getState()) transaccionOK(tipo);
        else transaccionNoOK(tipo);
    }
}
