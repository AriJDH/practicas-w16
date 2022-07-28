package main;

public class Main {
    public static void main(String[] args) {
        Ejecutivos ejecutivo= new Ejecutivos();
        Colaboradores colaborador=new Colaboradores();
        Basic basic=new Basic();
        ejecutivo.deposito(100,true);
        ejecutivo.transferencia(111,true);
        colaborador.consultarSaldo("Nombre");
        colaborador.retiroEfectivo(1000,true);
        basic.consultarSaldo("Nombre");
        basic.pagoDeServicios(100,true);
        basic.retiroEfectivo(100,true);


    }
}
