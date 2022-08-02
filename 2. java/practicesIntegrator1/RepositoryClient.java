package practicesIntegrator1;

import java.util.stream.Stream;

public class RepositoryClient implements IRepository<Client>{

    Client _client = new Client();

    public RepositoryClient(Client client) {
        _client = client;
    }

    @Override
    public Client create(Client object) {
        _client.setDbClients(object);

        return object;
    }

    @Override
    public Client consult(Client object) {
        Client clientFound = _client.getDbClients().stream().filter(x -> x.getDni().equals(object.getDni())).findFirst().orElse(null);

        return clientFound;
    }

    @Override
    public boolean delete(Client object) {

        Client clientFound = consult(object);

        if (clientFound == null) {
            System.out.println("No se pudo completar la accion porque el cliente con dni: " + object.getDni() + " no existe");
            return false;
        }

        boolean resultDelete = _client.getDbClients().remove(object);

        return resultDelete;
    }

    @Override
    public boolean update(Client object) {
        Client clientFound = consult(object);

        if (clientFound.getDni().isEmpty()) {
            System.out.println("No se pudo completar la accion porque el cliente con dni: " + object.getDni() + " no existe");
            return false;
        }

        delete(object);
        create(object);

        return true;
    }

    public Client consultByDni(String dni) {
        Client clientFound = _client.getDbClients().stream().filter(x -> x.getDni().equals(dni)).findFirst().orElse(null);

        if (clientFound == null) {
            System.out.println("El cliente con dni: " + dni + " no fue encontrado");
            return null;
        }

        System.out.println(clientFound);
        return clientFound;
    }
}
