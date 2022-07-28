package  ExerciseOne.actors;

import  ExerciseOne.interfaces.*;

public class Basic implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo {

    @Override
    public void transaccionNoOK(String tipoTransaccion){
        System.out.println("La transaccion - " + tipoTransaccion + " no se ha realizado.");
    }

    @Override 
    public void transaccionOK(String tipoTransaccion){
        System.out.println("La transaccion - " + tipoTransaccion + " se ha realizado con exito.");
    }

    @Override
    public void hacerRetiro() {
        
    }

    @Override
    public void pagarServicio(String service) {
        
    }

    @Override
    public void consultarSaldo() {
        
    }
    
}
