package practicesInterfaceAbstract1;

public class Deposit implements Transaction {

    @Override
    public void transactionOk() {
        System.out.println("Deposito realizado");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Deposito NO realizado");
    }
}
