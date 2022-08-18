import java.util.List;

public class Invoice {
    private Client client;
    private List<Item> items;
    private Integer total;

    public Invoice() {
    }

    public Invoice(Client client, List<Item> items, Integer total) {
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
