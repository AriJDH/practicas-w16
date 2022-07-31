package banco.clases;

import banco.interfaces.Deposito;
import banco.interfaces.Transferencia;

public class Ejecutivos implements Deposito, Transferencia {

    private final double fondos = 30000;
    private double dinero;

    public Ejecutivos(double dinero) {
        this.dinero = dinero;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    @Override
    public void depositar(){
        System.out.println("El cliente ejecutivo intenta realizar el deposito de "+this.dinero);
        transaccionOk("Deposito de dinero");
    }

    @Override
    public void transferir(){
        System.out.println("El cliente ejecutivo intenta transferir "+this.dinero);
        if (this.dinero<=this.fondos){
            transaccionOk("Transferencia");
        }
        else{
            transaccionNoOk("Transferencia");
        }
    }
    public void transaccionOk(String tipo){
        System.out.println(tipo+" Exitosa"
        );
    }

    public void transaccionNoOk(String tipo){

        System.out.println(tipo+ " Rechazada, revise sus fondos");
    }
}
