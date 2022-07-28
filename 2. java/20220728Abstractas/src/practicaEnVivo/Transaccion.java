package practicaEnVivo;

public interface Transaccion{

    default void transaccionOK() {

    }

    void transaccionNOOK();
}
