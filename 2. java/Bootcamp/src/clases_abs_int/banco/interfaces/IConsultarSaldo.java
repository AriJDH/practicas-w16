package clases_abs_int.banco.interfaces;

import java.util.concurrent.ThreadLocalRandom;

public interface IConsultarSaldo extends ITransaccion {
    default void consultarSaldo(){
        System.out.println("Realizando consulta de saldo...");
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
        if(randomNum == 0) transaccionOk();
        else transaccionNoOk();
    };
}
