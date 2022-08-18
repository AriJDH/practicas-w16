import java.util.List;

public class Invoice {
    private Client client;
    private List<Item> items;
    private Double total;

    public Invoice() {
    }

    public Invoice(Client client, List<Item> items, Double total) {
        this.client = client;
        this.items = items;
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
