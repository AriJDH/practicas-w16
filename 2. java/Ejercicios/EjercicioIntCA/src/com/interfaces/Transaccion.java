package com.interfaces;

public interface Transaccion {


    public abstract void transaccionOk(String tipoTransacc);
    public abstract void transaccionNoOk(String tipoTransacc);


}
