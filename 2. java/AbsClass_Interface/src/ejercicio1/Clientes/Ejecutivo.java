package ejercicio1.Clientes;

import ejercicio1.ClasesAbstractas.Cliente;
import ejercicio1.Interfaces.Deposito;
import ejercicio1.Interfaces.Transferencia;

public class Ejecutivo extends Cliente implements Deposito, Transferencia {

    @Override
    public String DepositoOK() {
        return "Depósito efectuado con éxito";
    }

    @Override
    public String DepositoNoOk() {
        return "El depósito ha fallado miserablemente";
    }

    @Override
    public String TransferenciaOK() {
        return "El dinero ha sido transferido a la cuenta indicada";
    }

    @Override
    public String TransferenciaNoOk() {
        return "Ha habido un problema con la transferencia";
    }

    public Ejecutivo() {
    }

    public Ejecutivo(String dni, String nombre) {
        super(dni, nombre);
    }
}
