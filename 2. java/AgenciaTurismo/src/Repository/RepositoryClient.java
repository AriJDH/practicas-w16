package Repository;

import Entity.Client;

import java.util.ArrayList;
import java.util.List;

public class RepositoryClient {
    private List<Client> clients;

    public RepositoryClient() {
        clients = new ArrayList<>();
    }

    public void addClientes(Client client){
        clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
