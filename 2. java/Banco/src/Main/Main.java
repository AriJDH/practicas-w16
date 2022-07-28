package Main;

import cliente.Basic;

public class Main {


    public static void main(String[] args){
        Basic basico = new Basic();
        basico.realizarDeposito();
        basico.realizarTransferencia();
        basico.transaccionNoOK();
        basico.transaccionOK();
    }
}
