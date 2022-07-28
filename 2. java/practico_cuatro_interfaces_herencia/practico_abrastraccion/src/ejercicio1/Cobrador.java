package ejercicio1;

public class Cobrador extends Cliente implements TransaccionCobrador{


    @Override
    public void retiroEfectivo() {
        System.out.print("retiro de efectivo OK");

    }

    @Override
    public void consultaSaldo() {
        System.out.print("consulta de saldo ok");

    }
}
