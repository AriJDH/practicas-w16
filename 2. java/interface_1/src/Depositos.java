public class Depositos  implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println( "Error en la transaccion");
    }
}
