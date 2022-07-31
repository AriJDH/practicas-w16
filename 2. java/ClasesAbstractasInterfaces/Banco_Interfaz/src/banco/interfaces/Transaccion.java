package banco.interfaces;

public interface Transaccion {

    public void transaccionOk(String tipo);
    public void transaccionNoOk(String tipo);
}
