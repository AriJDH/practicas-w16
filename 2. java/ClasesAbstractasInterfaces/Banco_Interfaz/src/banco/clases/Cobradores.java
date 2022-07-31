package banco.clases;

import banco.interfaces.ConsultaSaldo;
import banco.interfaces.RetiroEfectivo;

public class Cobradores implements RetiroEfectivo, ConsultaSaldo {


    private final double fondos = 500000;
    private double dinero;

    public Cobradores(double dinero) {
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
        System.out.println("El cobrador intenta realizar el retiro de "+this.dinero);
        if (this.dinero<=this.fondos){
            transaccionOk("Retiro de dinero");
        }
        else{
            transaccionNoOk("Retiro de dinero");
        }
    }

    @Override
    public void consultar(){
        System.out.println("El cobrador desea conocer su saldo");
        transaccionOk("Consulta de dinero");
        System.out.println("Cuenta con "+fondos);
    }

    public void transaccionOk(String tipo){
        System.out.println(tipo+" Exitoso"
        );
    }


    public void transaccionNoOk(String tipo){

        System.out.println(tipo+ " Rechazado, revise sus fondos");
    }

}
