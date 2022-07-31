package banco.clases;

public class Main {
    public static void main(String[] args){
        Basic basic = new Basic(5000);
        Ejecutivos ejectutivo = new Ejecutivos(32500);
        Cobradores cobrador = new Cobradores(56000);


        basic.retirar();
        basic.consultar();
        basic.pagarServicios();

        ejectutivo.depositar();
        ejectutivo.transferir();

        cobrador.consultar();
        cobrador.retirar();
    }

}
