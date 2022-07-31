public class Cliente {
    private String dni;
    private String name;
    private String lastName;

    public Cliente() {
    }

    public Cliente(String dni, String name, String lastName) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "\n Clientes: \n" +
                "Dni = " + dni + "\n" +
                "Name = " + name + "\n" +
                "Last Name = " + lastName;
    }
}
