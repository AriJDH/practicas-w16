package ejercicio1;

public class Basic extends  Cliente implements TransaccionBasic{


    @Override
    public void consultaSaldo() {
        System.out.print("consulto saldo ok");
    }

    @Override
    public void pagoServicio() {
        System.out.print("Pago de servicio OK");

    }

    @Override
    public void retiroEfectivo() {
        System.out.print("retiro de efectivo OK");
    }
}
