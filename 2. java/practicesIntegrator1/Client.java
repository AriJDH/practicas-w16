package practicesIntegrator1;

import java.util.HashSet;
import java.util.Set;

public class Client {

    private String dni;
    private String name;
    private String lastName;

    private Set<Client> dbClients = new HashSet<>();

    public Client() {
    }

    public Client(String dni, String name, String lastName) {
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

    public Set<Client> getDbClients() {
        return dbClients;
    }

    public void setDbClients(Client dbClients) {
        this.dbClients.add(dbClients);
    }

    @Override
    public String toString() {
        return "Client: " + " DNI: " + dni + " - Nombre: " + name + " - Apellido: " + lastName;
    }
}
