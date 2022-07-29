package practica_3.ejercicio1;

public class Basic implements PagoDeServicios, RetiroDeEfectivo, ConsultaDeSaldo {
    @Override
    public void ConsultaSaldo() {
        ConsultaDeSaldo.super.ConsultaSaldo();
    }

    @Override
    public void PagoServicio() {
        PagoDeServicios.super.PagoServicio();
    }

    @Override
    public void retiroDinero() {
        RetiroDeEfectivo.super.retiroDinero();
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no OK");
    }
}
