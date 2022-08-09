package ejercicioBanco;

public class Main {
    public static void main(String[] args) {

        IDeposito deposito = new Deposito();
        IPagoServicio pagoServicios = new PagoServicios();
        ISaldo saldo = new Saldo();
        ITransferencia transferencia = new Transferencia();
        IRetiroEfectivo retiroEfectivo = new RetiroEfectivo();

        IBasic mati = new Basic(saldo, retiroEfectivo, pagoServicios);
        ICobrador meli = new Cobrador(saldo, retiroEfectivo);
        IEjecutivo german = new Ejecutivo(deposito, transferencia);

        mati.pagarServicio();
        mati.retirarEfectivo();
        mati.consultarSaldo();

        meli.consultarSaldo();
        meli.retirarEfectivo();

        german.depositar();
        german.transferir();
    }
}