package clases_abs_int.banco.interfaces;

import java.util.concurrent.ThreadLocalRandom;

public interface ITransferencia extends ITransaccion {

    default void transferir(){
        System.out.println("Realizando transferencia...");
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
        if(randomNum == 0) transaccionOk();
        else transaccionNoOk();
    }
}
