package generics;

import java.util.List;

public class Garage {

  private double id;
  private List<Vehicle> listVehicles;

  public Garage() {
  }

  public Garage(double id, List<Vehicle> listVehicles) {
    this.id = id;
    this.listVehicles = listVehicles;
  }

  public double getId() {
    return id;
  }

  public void setId(double id) {
    this.id = id;
  }

  public List<Vehicle> getlistVehicles() {
    return listVehicles;
  }

  public void setlistVehicles(List<Vehicle> listVehicles) {
    this.listVehicles = listVehicles;
  }
}
