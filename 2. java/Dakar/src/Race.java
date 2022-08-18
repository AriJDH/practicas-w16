import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {
    private Double distance;
    private Double dollarsAward;
    private String name;
    private Integer numberVehiclesAllowed;
    private List<Vehicle> vehicleList;

    private LifeguardCar lifeguardCar;
    private LifeguardMotorcycle lifeguardMotorcycle;

    public Race() {
    }

    public Race(Integer numberVehiclesAllowed) {
        this.numberVehiclesAllowed = numberVehiclesAllowed;
        vehicleList = new ArrayList<>();
    }

    public Race(Double distance, Double dollarsAward, String name, Integer numberVehiclesAllowed, List<Vehicle> vehicleList) {
        this.distance = distance;
        this.dollarsAward = dollarsAward;
        this.name = name;
        this.numberVehiclesAllowed = numberVehiclesAllowed;
        this.vehicleList = vehicleList;
    }

    public void registerAuto(Double speed,Double acceleration, Double turningAngle, String patent) {
        if (vehicleList.size() < numberVehiclesAllowed) {
            System.out.println("Se agrego el carro con patente: " + patent);
            vehicleList.add(new Car(speed, acceleration, turningAngle, patent));
        } else {
            System.out.println("Se supero el limite " + patent);
        }
    }

    public void registerMotorcycle(Double speed,Double acceleration, Double turningAngle, String patent) {
        if (vehicleList.size() < numberVehiclesAllowed) {
            System.out.println("Se agrego la moto con patente: " + patent);
            vehicleList.add(new Motorcycles(speed, acceleration, turningAngle, patent));
        } else {
            System.out.println("Se supero el limite " + patent);
        }
    }

    public void deleteVehicle(Vehicle vehicle) {
        System.out.println("Se elimino el vehiculo");
        Vehicle vehicleAux = vehicleList.stream().filter(vehicleAux_ -> vehicleAux_.getPatent().equals(vehicle.getPatent())).findFirst().orElse(null);

        vehicleList.remove(vehicleAux);
    }

    public void deleteVehiclePatent(String patent) {
        Vehicle vehicle = vehicleList.stream().filter(vehicleAux -> vehicleAux.getPatent().equals(patent)).findFirst().orElse(null);
        System.out.println("Se elimino el vehiculo con patente: " + vehicle.getPatent());
        vehicleList.remove(vehicle);
    }

    public void defineWinner() {
        vehicleList.stream().forEach(vehicle -> vehicle.setCalculation(( vehicle.getSpeed() * (vehicle.getAcceleration()/2)) / (vehicle.getTurningAngle()*(vehicle.getWeight() - vehicle.getWheel() * 100)) ));
        Double winner = vehicleList.stream().mapToDouble(vehicle -> vehicle.getCalculation()).max().getAsDouble();
        Vehicle vehicle = vehicleList.stream().filter(vehicle1 -> vehicle1.getCalculation().toString().equals(winner.toString())).findFirst().orElse(null);
        System.out.println("El vehiculo ganador es: " + vehicle.toString());
    }

    public void helpCar(String patent) {
        Car car = (Car) vehicleList.stream().filter(vehicleAux -> vehicleAux.getPatent().equals(patent)).findFirst().orElse(null);

        lifeguardCar = new LifeguardCar();
        lifeguardCar.help(car);
    }

    public void helpMotorcycle(String patent) {
        Motorcycles motorcycle = (Motorcycles) vehicleList.stream().filter(vehicleAux -> vehicleAux.getPatent().equals(patent)).findFirst().orElse(null);

        lifeguardMotorcycle = new LifeguardMotorcycle();
        lifeguardMotorcycle.help(motorcycle);
    }
}
