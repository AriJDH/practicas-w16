package Ejercicio1;

public class Ejecutivo extends Cliente  {

    public Ejecutivo(String name, String dni, String clientType) {
        super(name, dni, clientType);
    }

    Deposito depositos = new Deposito();
    Transferencia transferencias = new Transferencia();

    public void transferencia(){
        transferencias.transaccionOk();
    }

    public void deposito(){
        depositos.transaccionNoOk();
    }
}
