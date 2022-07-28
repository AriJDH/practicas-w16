package ejercicio1;

public class Bank {

    public void executeTransactionFor(CustomerType aCustomerType, TransactionType aTransactionType) {
        aTransactionType.performTransactionBy(aCustomerType);
    }

}
