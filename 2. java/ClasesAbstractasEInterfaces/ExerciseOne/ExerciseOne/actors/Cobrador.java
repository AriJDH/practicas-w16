package   ExerciseOne.actors;

import   ExerciseOne.interfaces.*;

public class Cobrador implements RetiroDeEfectivo, ConsultaDeSaldo{

    @Override
    public void transaccionNoOK(String tipoTransaccion){
        System.out.println("La transaccion - " + tipoTransaccion + " no se ha realizado.");
    }

    @Override 
    public void transaccionOK(String tipoTransaccion){
        System.out.println("La transaccion - " + tipoTransaccion + " se ha realizado con exito.");
    }

    @Override
    public void consultarSaldo() {
        
    }

    @Override
    public void hacerRetiro() {
    
    }
    
}
