package ejercicio1;

import java.util.List;

public class Deposit extends TransactionType {

    public Deposit() {
        allowedCustomers = List.of(CustomerType.EXECUTIVE);
    }

    @Override
    public void transactionOk() {
        System.out.println("Realizándose depósito con éxito.");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("No se puedo realizar el depósito.");
    }
}
