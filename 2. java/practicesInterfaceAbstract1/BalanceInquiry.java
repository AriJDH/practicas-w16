package practicesInterfaceAbstract1;

public class BalanceInquiry implements Transaction {
    @Override
    public void transactionOk() {
        System.out.println("Consulta de saldo realizada");
    }

    @Override
    public void transactionNoOk() {
        System.out.println("Consulta de saldo NO realizada");
    }
}
