package ejercicio1.Clientes;

import ejercicio1.ClasesAbstractas.Cliente;
import ejercicio1.Interfaces.ConsultaSaldo;
import ejercicio1.Interfaces.RetiroEfectivo;

public class Cobrador extends Cliente implements RetiroEfectivo, ConsultaSaldo {
    @Override
    public String ConsultaSaldoOK() {
        return "Consulta de saldo exitosa";
    }

    @Override
    public String ConsultaSaldoNoOk() {
        return "No se ha podido obtener el dato solicitado";
    }

    @Override
    public String RetiroEfectivoOK() {
        return "Retiro en efectivo OK, gaste sabiamente su dinero";
    }

    @Override
    public String RetiroEfectivoNoOk() {
        return "Cuenta sin saldo, lo sentimos terriblemente";
    }

    public Cobrador() {
    }

    public Cobrador(String dni, String nombre) {
        super(dni, nombre);
    }
}
