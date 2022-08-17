package ExerciseOne;

public class Executive {
    private Deposit deposit = new Deposit();
    private Transfer transfer = new Transfer();

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }
}
