package generics;

public class Vehicle {

  private String brand;
  private String model;
  private int price;

  public String getbrand() {
    return brand;
  }

  public void setbrand(String brand) {
    this.brand = brand;
  }

  public String getmodel() {
    return model;
  }

  public void setmodel(String model) {
    this.model = model;
  }

  public int getprice() {
    return price;
  }

  public void setprice(int price) {
    this.price = price;
  }

  public Vehicle(String brand, String model, int price) {
    this.brand = brand;
    this.model = model;
    this.price = price;
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        ", price=" + price +
        '}';
  }

}
