package BancoEjercicio1;

public class Ejecutivo implements Transaccion {

   public void realizarDeposito(boolean condicion){
       if(condicion){
       System.out.println("Deposito del cliente ejecutivo realizado");
           transaccionOk();
       }
       transaccionNoOk();
   }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion del cliente ejecutivo realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion del cliente ejecutivo no realizada");
    }

}
