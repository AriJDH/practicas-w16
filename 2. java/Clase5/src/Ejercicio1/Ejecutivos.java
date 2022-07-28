package Ejercicio1;

public class Ejecutivos {
    public boolean realizarDeposito(){
        Transaccion trn = new Deposito();
        return trn.transaccionOk();
    }

    public static void main(String[] args) {
        Ejecutivos eje = new Ejecutivos();
        eje.realizarDeposito();
    }
}
