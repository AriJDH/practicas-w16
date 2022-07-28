package ejercicio1;

import java.util.Collections;
import java.util.List;

public abstract class TransactionType implements Transaction {

    protected List<CustomerType> allowedCustomers;

    public void performTransactionBy(CustomerType aCustomerType) {
        if (isAllowedCustomer(aCustomerType)) {
            transactionOk();
        } else {
            transactionNoOk();
        }
    }

    private boolean isAllowedCustomer(CustomerType aCustomerType) {
        return allowedCustomers.contains(aCustomerType);
    }

}
