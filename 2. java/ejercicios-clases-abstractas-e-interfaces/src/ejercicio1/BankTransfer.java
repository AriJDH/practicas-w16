package ejercicio1;

import java.util.List;

public class BankTransfer extends TransactionType {

    public BankTransfer() {
        allowedCustomers = List.of(CustomerType.EXECUTIVE);
    }

    @Override
    public void transactionOk() {
        System.out.println("Realizándose transferencia con éxito.");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("No se puedo realizar la transferencia.");
    }
}
