package practicesInterfaceAbstract1;

public class Transfer implements Transaction {

    @Override
    public void transactionOk() {
        System.out.println("Transferencia realizada");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Transferencia NO realizada");
    }
}
