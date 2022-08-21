package JavaAbstractInterfaceVIVO.ejercicio1;

public class Banco {

    public static void main(String[] args) {
        Ejecutivos ejecutivos = new Ejecutivos();
        ejecutivos.deposito();
        ejecutivos.transferencia();

        Basic basic = new Basic();
        basic.consultaSaldo();
        basic.pagosDeServicios();
        basic.retiroEfectivo();

        Cobrador cobrador = new Cobrador();
        cobrador.consultaSaldo();
        cobrador.retiroEfectivo();
    }
}
