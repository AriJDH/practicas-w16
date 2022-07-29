package practicesInterfaceAbstract1;

public class CashWithdrawal implements Transaction {

    @Override
    public void transactionOk() {
        System.out.println("Retiro de efectivo realizado");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Retiro de efectivo NO realizado");
    }
}
