public class Item {
    private String code;
    private String name;
    private int amount;
    private double unitCost;

    public Item() {
    }

    public Item(String code, String name, int amount, double unitCost) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }
}
