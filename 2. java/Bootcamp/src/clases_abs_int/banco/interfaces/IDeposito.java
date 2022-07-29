package clases_abs_int.banco.interfaces;

import java.util.concurrent.ThreadLocalRandom;

public interface IDeposito extends ITransaccion {
    default void depositar(){
        System.out.println("Realizando depósito...");
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
        if(randomNum == 0) transaccionOk();
        else transaccionNoOk();
    }
}
