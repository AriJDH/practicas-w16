package practicesInterfaceAbstract1;

public class Executive extends Client {

    private Deposit deposit;
    private Transfer transfer;

    public Executive(String nombre, String apellido, String dni, Deposit deposit, Transfer transfer) {
        super(nombre, apellido, dni);
        this.deposit = deposit;
        this.transfer = transfer;
    }

    public Executive(String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    @Override
    public String toString() {
        return "Datos del cliente: " +
                "\nname: " + name +
                "\nlastname: " + lastname +
                "\ndni: " + dni;
    }
}
