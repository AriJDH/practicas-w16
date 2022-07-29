package ejercicioIntegrador;

import java.util.UUID;

public class Item {

    private final UUID code;
    private final String productName;
    private final Integer amount;
    private final Double unitCost;

    public Item(UUID code, String productName, Integer amount, Double unitCost) {
        this.code = code;
        this.productName = productName;
        this.amount = amount;
        this.unitCost = unitCost;
    }

    public Double price() {
        return amount * unitCost;
    }
}
