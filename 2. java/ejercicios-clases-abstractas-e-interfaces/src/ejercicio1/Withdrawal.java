package ejercicio1;

import java.util.List;

public class Withdrawal extends TransactionType {

    public Withdrawal() {
        allowedCustomers = List.of(CustomerType.BASIC, CustomerType.COLLECTOR);
    }

    @Override
    public void transactionOk() {
        System.out.println("Realizándose extracción con éxito.");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("No se puedo realizar la extracción de efectivo.");
    }
}
