package clases_abs_int.banco.interfaces;

import java.util.concurrent.ThreadLocalRandom;

public interface IPagoServicio extends ITransaccion {
    default void pagarServicio(){
        System.out.println("Realizando pago de servicio...");
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
        if(randomNum == 0) transaccionOk();
        else transaccionNoOk();
    }
}
