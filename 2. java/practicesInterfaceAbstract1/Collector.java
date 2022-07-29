package practicesInterfaceAbstract1;

public class Collector extends Client {

    private CashWithdrawal cashWithdrawal;
    private BalanceInquiry balanceInquiry;

    public Collector(String name, String lastname, String dni, CashWithdrawal cashWithdrawal, BalanceInquiry balanceInquiry) {
        super(name, lastname, dni);
        this.cashWithdrawal = cashWithdrawal;
        this.balanceInquiry = balanceInquiry;
    }

    public CashWithdrawal getCashWithdrawal() {
        return cashWithdrawal;
    }

    public BalanceInquiry getBalanceInquiry() {
        return balanceInquiry;
    }

    @Override
    public String toString() {
        return "Datos del cliente:" +
                "\nname: " + name +
                "\nlastname: " + lastname +
                "\ndni: " + dni;
    }
}
