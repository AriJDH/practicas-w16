package absandint.ejercicio1.Clientes;

public class Main {

    public static void main(String[] args) {
        Basic cliente = new Basic();

        cliente.realizarConsulta();
        cliente.realizarPago();

        Ejecutivos cliente2 = new Ejecutivos();
        cliente2.realizarDeposito();
        cliente2.realizarTransferencia();

        Cobradores cliente3 = new Cobradores();
        cliente3.realizarRetiro();
    }
}
