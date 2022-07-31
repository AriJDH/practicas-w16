import java.util.List;

public class Garage {

    private int id;
    private List<Vehiculo> autos;


    public Garage(int id, List  autos){

        this.autos=autos;
        this.id=id;

    }

    public void setAutos(List<Vehiculo> autos) {
        this.autos = autos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<Vehiculo> getAutos() {
        return autos;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", autos=" + autos +
                '}';
    }
}
