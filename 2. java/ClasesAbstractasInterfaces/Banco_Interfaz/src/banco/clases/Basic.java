package banco.clases;

import banco.interfaces.ConsultaSaldo;
import banco.interfaces.PagoServicios;
import banco.interfaces.RetiroEfectivo;

public class Basic implements ConsultaSaldo, PagoServicios, RetiroEfectivo {

    private final double fondos = 10000;
    private double dinero;

    public Basic(double dinero) {
        this.dinero = dinero;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    @Override
    public void retirar(){
        System.out.println("El cliente Basic intenta realizar el retiro de "+this.dinero);
        if (this.dinero<=this.fondos){
            transaccionOk("Retiro de dinero");
        }
        else{
            transaccionNoOk("Retiro de dinero");
        }
    }

    @Override
    public void pagarServicios(){
        System.out.println("El cliente Basic intenta realizar el pago de "+this.dinero+" en servicios");
        transaccionOk("Pago de servicios");
    }


    @Override
    public void consultar(){
        System.out.println("El cliente Basic desea conocer su saldo");
        transaccionOk("Consulta de dinero");
        System.out.println("Cuenta con "+fondos);
    }

    @Override
    public void transaccionOk(String tipo){
        System.out.println(tipo+" Exitoso");
    }

    @Override
    public void transaccionNoOk(String tipo){
        System.out.println(tipo+ " Rechazado, revise sus fondos");
    }

}
