import java.util.List;

public class Garage {
    private int id;
    private List<Vehicle> listVehicles;

    public Garage(int id, List<Vehicle> listVehicles) {
        this.id = id;
        this.listVehicles = listVehicles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehicle> getListVehicles() {
        return listVehicles;
    }

    public void setListVehicles(List<Vehicle> listVehicles) {
        this.listVehicles = listVehicles;
    }

    public void setVehicle(Vehicle vehicle){
        this.listVehicles.add(vehicle);
    }

    @Override
    public String toString() {
        return "**** Garage \n" +
                "- Id = " + id +
                "- List of Vehicles = " + listVehicles + " \n" ;
    }
}
