import java.util.List;

public class Factura {
    private int id;
    private Cliente client;
    private List<Item> itemList;
    private double totalCost;

    public Factura() {
    }

    public Factura(int id, Cliente client, List<Item> itemList, double totalCost) {
        this.id = id;
        this.client = client;
        this.itemList = itemList;
        this.totalCost = totalCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "\nFactura: \n" +
                "Id = " + id + " \n" +
                "Cliente = " + client + " \n" +
                "Lista de Items = " + itemList + " \n" +
                "Costo Total = " + totalCost + " \n";
    }
}
