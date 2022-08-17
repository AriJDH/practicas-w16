package ExerciseOne;

public class Main {
    public static void main(String[] args) {
        Executive executive = new Executive();
        Basic basic = new Basic();
        DebtCollector debtCollector = new DebtCollector();

        System.out.println("--------------------------");
        System.out.println("Ejecutivos");
        executive.getDeposit().transaccionOk();
        executive.getDeposit().transaccionNoOk();
        executive.getTransfer().transaccionOk();
        executive.getTransfer().transaccionNoOk();

        System.out.println("--------------------------");
        System.out.println("Basic");
        basic.getBalanceInquiry().transaccionOk();
        basic.getBalanceInquiry().transaccionNoOk();
        basic.getCashWithdrawal().transaccionOk();
        basic.getCashWithdrawal().transaccionNoOk();
        basic.getServicesPay().transaccionOk();
        basic.getServicesPay().transaccionNoOk();

        System.out.println("--------------------------");
        System.out.println("Cobradores");
        debtCollector.getBalanceInquiry().transaccionOk();
        debtCollector.getBalanceInquiry().transaccionNoOk();
        debtCollector.getCashWithdrawal().transaccionOk();
        debtCollector.getCashWithdrawal().transaccionNoOk();
    }
}
