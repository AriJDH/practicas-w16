public class Garment {
  private String brand; //marca
  private String model; // modelo

  public Garment() {
  }

  public Garment(String brand, String model) {
    this.brand = brand;
    this.model = model;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  @Override
  public String toString() {
    return "Garment{" +
            "brand='" + brand + '\'' +
            ", model='" + model + '\'' +
            '}';
  }
}
