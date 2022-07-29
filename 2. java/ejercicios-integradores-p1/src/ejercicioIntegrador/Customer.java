package ejercicioIntegrador;

public class Customer {

    private final Integer dni;
    private final String name, surname;

    public Customer(Integer dni, String name, String surname) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "dni=" + dni +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public Integer getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
