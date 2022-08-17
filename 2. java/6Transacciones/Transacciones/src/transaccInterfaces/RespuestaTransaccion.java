package transaccInterfaces;

public interface RespuestaTransaccion {

    public abstract void transaccionOK(String msg);

    public abstract void transaccionNoOK(String msg);


}
