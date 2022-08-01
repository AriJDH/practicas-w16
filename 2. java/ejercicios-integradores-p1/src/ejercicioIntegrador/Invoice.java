package ejercicioIntegrador;

import java.util.HashMap;
import java.util.List;

public class Invoice {

    private final Customer buyer;
    private final List<Item> items;

    public Invoice(Customer buyer, List<Item> items) {
        this.buyer = buyer;
        this.items = items;
    }

    public Double totalPrice() {
        return items.stream().mapToDouble(Item::price).sum();
    }

    public Customer getCustomer() {
        return buyer;
    }
}
