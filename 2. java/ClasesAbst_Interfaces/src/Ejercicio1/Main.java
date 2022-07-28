package Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Basic clienteBasico = new Basic();
        clienteBasico.consultarSaldo();
        clienteBasico.retirarEfectivo(200);
        clienteBasico.pagarServicios();
        clienteBasico.transaccionNoOk("deposito");
    }
}
