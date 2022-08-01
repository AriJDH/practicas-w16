package practicesLambdaGenericStream1;

public class Car {
    private String model;
    private String brand;
    private float price;

    public Car(String model, String brand, float price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car: " +
                "\nmodel: " + model +
                "\nbrand: " + brand +
                "\nprice: " + price;
    }
}
