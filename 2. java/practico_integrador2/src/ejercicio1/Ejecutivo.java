package ejercicio1;

public class Ejecutivo extends Cliente implements  TransaccionEjecutivo{


    @Override
    public void realizarDeposito() {
        System.out.println("deposito ok");

    }

    @Override
    public void realizarTransferencia() {
        System.out.println("transferencia");

    }
}
