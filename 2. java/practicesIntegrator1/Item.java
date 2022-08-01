package practicesIntegrator1;

public class Item {

    private String code;
    private String name;
    private int amount;
    private float unitCost;

    public Item() {
    }

    public Item(String code, String name, int amount, float unitCost) {
        this.code = code;
        this.name = name;
        this.amount = amount;
        this.unitCost = unitCost;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Item: " + " Codigo: " + code + " - Nombre: " + name + " - Cantidad: " + amount + " - Costo Unitario: " + unitCost;
    }
}
