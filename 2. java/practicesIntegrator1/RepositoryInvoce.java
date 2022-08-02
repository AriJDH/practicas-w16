package practicesIntegrator1;

import java.util.List;

public class RepositoryInvoce implements IRepository<Invoce>{

    Invoce _invoce = new Invoce();

    public RepositoryInvoce(Invoce invoce) {
        this._invoce = invoce;
    }

    @Override
    public Invoce create(Invoce object) {
        RepositoryClient repositoryClient = new RepositoryClient(object.getClient());
        Client resultExistClient = repositoryClient.consult(object.getClient());

        if (resultExistClient == null) {
            Client client = repositoryClient.create(object.getClient());
            object.setClient(client);
        }

        float total = calculateTotal(object.getListItems());
        object.setTotal(total);

        _invoce.setDbInvoce(object);

        return object;
    }

    @Override
    public Invoce consult(Invoce object) {
        Invoce clientFound = _invoce.getDbInvoce().stream().filter(x -> x.getClient().equals(object.getClient())).findFirst().orElse(null);

        return clientFound;
    }

    @Override
    public boolean delete(Invoce object) {
        Invoce invoceFound = consult(object);

        if (invoceFound == null) {
            System.out.println("No se pudo completar la accion porque la factura " + object + " no existe");
            return false;
        }

        boolean resultDelete = _invoce.getDbInvoce().remove(object);

        return resultDelete;
    }

    @Override
    public boolean update(Invoce object) {
        Invoce invoceFound = consult(object);

        if (invoceFound == null) {
            System.out.println("No se pudo completar la accion porque la factura : " + object + " no existe");
            return false;
        }

        delete(object);
        create(object);

        return true;
    }

    public float calculateTotal(List<Item> itemsList) {
        float total = 0;

        for (Item item: itemsList) {
            total = total + (item.getUnitCost() * item.getAmount());
        }

        return total;
    }
}
