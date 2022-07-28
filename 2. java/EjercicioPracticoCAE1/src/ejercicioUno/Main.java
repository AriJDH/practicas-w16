package ejercicioUno;

import ejercicioUno.clientes.Basic;
import ejercicioUno.clientes.Cobrador;
import ejercicioUno.clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();

        basic.consultaSaldo("10203049");
        basic.pagoServicios("123123",120000.0);
        basic.retiroEfectivo(213012.0);

        cobrador.consultaSaldo("234234");
        cobrador.retiroEfectivo(212301.0);

        ejecutivo.deposito(345342.0);
        ejecutivo.transferencia(789789.0);
    }
}
