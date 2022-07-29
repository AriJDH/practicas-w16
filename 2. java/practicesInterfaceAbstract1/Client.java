package practicesInterfaceAbstract1;

public abstract class Client {
    protected String name;
    protected String lastname;
    protected String dni;

    public Client(String name, String lastname, String dni) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
    }

    public Client() {
    }
}
