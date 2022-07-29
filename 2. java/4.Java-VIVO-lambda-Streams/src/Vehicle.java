public class Vehicle {
    private String model;
    private String brand;
    private Integer cost;

    public Vehicle(String model, String brand, Integer cost) {
        this.model = model;
        this.brand = brand;
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "**** Vehicle \n" +
                " - Model = " + model + " \n" +
                " - Brand = " + brand + " \n" +
                " - Cost = " + cost + " \n";
    }
}
