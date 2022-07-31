package BancoEjercicio1;

public class Basic implements Transaccion,Cajero {

    public void pagosDeServicio(boolean condicion){
        if(condicion){
            System.out.println("Pago de servicio del cliente basic realizado");
            transaccionOk();
        }
        transaccionNoOk();
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion del cliente basic realizada");
    }

    @Override
    public void transaccionNoOk() {
    }

    @Override
    public void retiroDeEfectivo(boolean condicion) {
        if(condicion){
            System.out.println("Retiro de efectivo del cliente basic realizado");
            transaccionOk();
        }
        transaccionNoOk();
    }


    @Override
    public void consultaDeSaldo(boolean condicion) {
        if(condicion){
            System.out.println("Consulta de saldo del cliente basic realizado");
            transaccionOk();
        }
        transaccionNoOk();
    }

}
