package clases.abstractas.interfaces.Ejercicio1;

public class Main {
    public static void main(String[] args){
        Basic cliente = new Basic();
        cliente.extraerEfectivo(12345, 15000, false);
        cliente.consultarSaldo(345323, true);
    }
}
