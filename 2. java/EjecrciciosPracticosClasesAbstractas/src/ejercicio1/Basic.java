package ejercicio1;

public class Basic implements ConsultaSaldo,PagoServicios,RetiroEfectivo{

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion correcta");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion incorrecta");
    }

    @Override
    public void hacerConsultaSaldo() {
        System.out.println("Consultando saldo");
    }

    @Override
    public void hacerPagoServicio() {
        System.out.println("Pagando servicio");
    }

    @Override
    public void hacerRetiroEfectivo() {
        System.out.println("Retirando efectivo");
    }
}
