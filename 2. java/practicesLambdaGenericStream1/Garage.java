package practicesLambdaGenericStream1;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private int id;
    private List<Car> listCars = new ArrayList<>();

    public Garage(int id, List<Car> listCars) {
        this.id = id;
        this.listCars = listCars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Car> getListCars() {
        return listCars;
    }

    public void setListCars(List<Car> listCars) {
        this.listCars = listCars;
    }

    @Override
    public String toString() {
        return "Garage: " +
                "\nid: " + id +
                "\nlistCars: " + listCars;
    }
}
