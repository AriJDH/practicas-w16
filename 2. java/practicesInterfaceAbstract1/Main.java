package practicesInterfaceAbstract1;

public class Main {
    public static void main(String[] args) {

        Deposit deposit = new Deposit();
        Transfer transfer = new Transfer();
        CashWithdrawal cashWithdrawal = new CashWithdrawal();
        BalanceInquiry balanceInquiry = new BalanceInquiry();
        PaymentService paymentService = new PaymentService();

        Executive executive = new Executive("Mariana","Cano","12345", deposit, transfer);
        System.out.println("-----------------------------------");
        System.out.println(executive);
        executive.getDeposit().transactionNoOk();
        executive.getTransfer().transactionOk();
        System.out.println("-----------------------------------");

        Basic basic = new Basic("Juan","Cano","4567", balanceInquiry, cashWithdrawal, paymentService);
        System.out.println(basic);
        basic.getCashWithdrawal().transactionOk();
        basic.getBalanceInquiry().transactionNoOk();
        basic.getPaymentService().transactionNoOk();

        Collector collector = new Collector("Estiven","Cano","49473", cashWithdrawal, balanceInquiry);
        System.out.println("-----------------------------------");
        System.out.println(collector);
        collector.getBalanceInquiry().transactionNoOk();
        collector.getCashWithdrawal().transactionOk();
        System.out.println("-----------------------------------");
    }
}
