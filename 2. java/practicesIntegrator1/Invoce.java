package practicesIntegrator1;

import java.util.List;

public class Invoce {

    private Client client;
    private List<Item> listItems;
    private float total;

    public Invoce() {
    }

    public Invoce(Client client, List<Item> listItems, float total) {
        this.client = client;
        this.listItems = listItems;
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Item> getListItems() {
        return listItems;
    }

    public void setListItems(List<Item> listItems) {
        this.listItems = listItems;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Datos Factura: \n" +
                "Cliente: " + client +
                "Productos: " + listItems;
    }
}
