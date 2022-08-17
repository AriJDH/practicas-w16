public class Vehicle {
    private String model;
    private String marca;
    private Double cost;

    public Vehicle() {
    }

    public Vehicle(String model, String marca, Double cost) {
        this.model = model;
        this.marca = marca;
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
