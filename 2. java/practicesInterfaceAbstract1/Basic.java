package practicesInterfaceAbstract1;

public class Basic extends Client {

    private BalanceInquiry balanceInquiry;
    private CashWithdrawal cashWithdrawal;
    private PaymentService paymentService;

    public Basic(String name, String lastname, String dni, BalanceInquiry balanceInquiry, CashWithdrawal cashWithdrawal, PaymentService paymentService) {
        super(name, lastname, dni);
        this.balanceInquiry = balanceInquiry;
        this.cashWithdrawal = cashWithdrawal;
        this.paymentService = paymentService;
    }

    public Basic(String nombre, String apellido, String dni) {
        super(nombre, apellido,dni);
    }

    public BalanceInquiry getBalanceInquiry() {
        return balanceInquiry;
    }

    public void setBalanceInquiry(BalanceInquiry balanceInquiry) {
        this.balanceInquiry = balanceInquiry;
    }

    public CashWithdrawal getCashWithdrawal() {
        return cashWithdrawal;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    @Override
    public String toString() {
        return "Datos del cliente:" +
                "\nname: " + name  +
                "\nlastname: " + lastname +
                "\ndni: " + dni;
    }
}
