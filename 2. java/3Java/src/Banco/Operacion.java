package Banco;

public abstract class Operacion  {

    protected String transaccionOk(){
        return "Ok";
    }
    protected String transaccionNoOk(){
        return  "No Ok";
    }


}
