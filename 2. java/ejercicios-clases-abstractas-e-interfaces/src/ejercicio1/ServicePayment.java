package ejercicio1;

import java.util.List;

public class ServicePayment extends TransactionType {

    public ServicePayment() {
        allowedCustomers = List.of(CustomerType.BASIC);
    }

    @Override
    public void transactionOk() {
        System.out.println("Realizándose pago de servicio con éxito.");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("No se puedo realizar el pago de servicio.");
    }
}
