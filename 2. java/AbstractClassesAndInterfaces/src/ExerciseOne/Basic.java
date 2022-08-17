package ExerciseOne;

public class Basic {
    private BalanceInquiry balanceInquiry = new BalanceInquiry();
    private ServicesPay servicesPay = new ServicesPay();
    private CashWithdrawal cashWithdrawal = new CashWithdrawal();

    public BalanceInquiry getBalanceInquiry() {
        return balanceInquiry;
    }

    public void setBalanceInquiry(BalanceInquiry balanceInquiry) {
        this.balanceInquiry = balanceInquiry;
    }

    public ServicesPay getServicesPay() {
        return servicesPay;
    }

    public void setServicesPay(ServicesPay servicesPay) {
        this.servicesPay = servicesPay;
    }

    public CashWithdrawal getCashWithdrawal() {
        return cashWithdrawal;
    }

    public void setCashWithdrawal(CashWithdrawal cashWithdrawal) {
        this.cashWithdrawal = cashWithdrawal;
    }
}
