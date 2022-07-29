package practicesInterfaceAbstract1;

public class PaymentService implements Transaction {

    @Override
    public void transactionOk() {
        System.out.println("Pago de servicio realizado");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Pago de servicio NO realizado");
    }
}
