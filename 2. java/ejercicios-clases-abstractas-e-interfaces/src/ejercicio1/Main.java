package ejercicio1;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.executeTransactionFor(CustomerType.EXECUTIVE, new ServicePayment());
        bank.executeTransactionFor(CustomerType.BASIC, new ServicePayment());
        bank.executeTransactionFor(CustomerType.COLLECTOR, new BalanceEnquiry());
    }

}
