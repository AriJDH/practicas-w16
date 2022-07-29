import java.util.List;

public class Factura {
    private List<Item> items;
    private double total;

    public Factura(List<Item> items, double total) {
        this.items = items;
        this.total = total;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "items=" + items +
                ", total=" + total +
                '}';
    }
}
