package ejercicio1;

import java.util.List;

public class BalanceEnquiry extends TransactionType {

    public BalanceEnquiry() {
        allowedCustomers = List.of(CustomerType.COLLECTOR, CustomerType.BASIC);
    }

    @Override
    public void transactionOk() {
        System.out.println("Realizándose consulta de saldo con éxito.");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("No se puedo realizar consulta de saldo.");
    }
}
