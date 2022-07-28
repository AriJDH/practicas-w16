package ejercicio1.Clientes;

import ejercicio1.ClasesAbstractas.Cliente;
import ejercicio1.Interfaces.ConsultaSaldo;
import ejercicio1.Interfaces.PagoServicio;
import ejercicio1.Interfaces.RetiroEfectivo;

public class Basic extends Cliente implements ConsultaSaldo, PagoServicio, RetiroEfectivo {
    @Override
    public String ConsultaSaldoOK() {
        return "Se ha realizado la consulta de saldo";
    }

    @Override
    public String ConsultaSaldoNoOk() {
        return "Consulta de saldo fallida";
    }

    @Override
    public String PagoServicioOK() {
        return "¡Felicidades! Su servicio fue pagado con éxito";
    }

    @Override
    public String pagoServicioNoOk() {
        return "Lo sentimos, ha ocurrido un problema con su pago de servicio. ¡Siga participando!";
    }

    @Override
    public String RetiroEfectivoOK() {
        return "Retiro de efectivo exitoso";
    }

    @Override
    public String RetiroEfectivoNoOk() {
        return "El retiro de efectivo no pudo ser efectuado";
    }

    public Basic() {
    }

    public Basic(String dni, String nombre) {
        super(dni, nombre);
    }
}
