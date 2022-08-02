package ejercicio1;

public class Main {
    public static void main(String[] args) {

        Deposito deposito = new Deposito();
        Transferencia transferencia = new Transferencia();
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        ConsultaSaldo consultaSaldo = new ConsultaSaldo();
        PagoServicio pagoServicio = new PagoServicio();



        Ejecutivo ejec = new Ejecutivo("nombre","apellido","dni",deposito, transferencia);
        ejec.getDeposito().transaccionOk();
        ejec.getDeposito().transaccionNoOk();
        ejec.getTransferencia().transaccionOk();
        ejec.getTransferencia().transaccionNoOk();

        Basic basic = new Basic("nombre","apellido","dni",consultaSaldo, retiroEfectivo,pagoServicio );
        basic.getRetiroEfectivo().transaccionOk();
        basic.getRetiroEfectivo().transaccionNoOk();
        basic.getConsultaSaldo().transaccionOk();
        basic.getConsultaSaldo().transaccionNoOk();
        basic.getPagoServicio().transaccionOk();
        basic.getPagoServicio().transaccionNoOk();

        Cobrador cobrador = new Cobrador("nombre","apellido","dni",retiroEfectivo,consultaSaldo);
        cobrador.getConsultaSaldo().transaccionOk();
        cobrador.getConsultaSaldo().transaccionNoOk();
        cobrador.getRetiroEfectivo().transaccionOk();
        cobrador.getRetiroEfectivo().transaccionNoOk();


    }
}
