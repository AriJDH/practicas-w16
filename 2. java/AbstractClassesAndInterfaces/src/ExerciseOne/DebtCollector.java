package ExerciseOne;

public class DebtCollector {
    private CashWithdrawal cashWithdrawal = new CashWithdrawal();
    private BalanceInquiry balanceInquiry = new BalanceInquiry();

    public CashWithdrawal getCashWithdrawal() {
        return cashWithdrawal;
    }

    public void setCashWithdrawal(CashWithdrawal cashWithdrawal) {
        this.cashWithdrawal = cashWithdrawal;
    }

    public BalanceInquiry getBalanceInquiry() {
        return balanceInquiry;
    }

    public void setBalanceInquiry(BalanceInquiry balanceInquiry) {
        this.balanceInquiry = balanceInquiry;
    }
}
