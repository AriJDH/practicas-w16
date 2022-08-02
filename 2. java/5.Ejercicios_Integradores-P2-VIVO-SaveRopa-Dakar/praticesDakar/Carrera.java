package praticesDakar;

import java.util.List;
import java.util.stream.Stream;

public class Carrera {
    private double distancia;
    private float premioDolares;
    private String nombre;
    private int cantidadVehiculos;
    private List<Vehiculo> vehiculoList;

    public Carrera() {
    }

    public Carrera(double distancia, float premioDolares, String nombre, int cantidadVehiculos, List<Vehiculo> vehiculoList) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantidadVehiculos = cantidadVehiculos;
        this.vehiculoList = vehiculoList;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public float getPremioDolares() {
        return premioDolares;
    }

    public void setPremioDolares(float premioDolares) {
        this.premioDolares = premioDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public void setCantidadVehiculos(int cantidadVehiculos) {
        this.cantidadVehiculos = cantidadVehiculos;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioDolares=" + premioDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadVehiculos=" + cantidadVehiculos +
                ", vehiculoList=" + vehiculoList +
                '}';
    }

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        if (vehiculoList.size() >= cantidadVehiculos) {
            System.out.println("Limite superado");
        } else {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculoList.add(auto);
            System.out.println(auto);
        }
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        if (vehiculoList.size() >= cantidadVehiculos) {
            System.out.println("Limite superado");
        } else {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculoList.add(moto);
            System.out.println(moto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculoList.remove(vehiculo);
        System.out.println("Vehiculo eliminado " + vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        vehiculoList.removeIf(x -> x.getPatente().equals(patente));
        System.out.println("Vehiculo con patente " + patente + " eliminado");
    }

    public void ganadorCarrera() {
        double total = 0;
        double mayor = 0;
        Vehiculo vehiculoGanador = new Vehiculo();

        for (Vehiculo vehiculo: vehiculoList) {
            total = vehiculo.getVelocidad() * ((float)vehiculo.getAceleracion()/2);
            total = total / vehiculo.getAnguloDeGiro()*(vehiculo.getPeso() - vehiculo.getRuedas() * 100);

            if (total >= mayor) {
                mayor = total;
                vehiculoGanador =vehiculo;
            }
        }

        System.out.println("El vehiculo ganador fue: " + vehiculoGanador + " con un total de " + mayor);
    }

    public void socorrerAuto(String patente) {

        Auto auto;
        SocorristaAuto socorrerAuto = new SocorristaAuto();

        auto = (Auto) vehiculoList.stream().filter(x -> x.getPatente().equals(patente)).findFirst().orElse(null);

        if (auto != null)
            socorrerAuto.socorrer(auto);
        else
            System.out.println("No se encontro el auto: " + patente);
    }

    public void socorrerMoto(String patente) {

        Moto moto;
        SocorristaMoto socorrerMoto = new SocorristaMoto();

        moto = (Moto) vehiculoList.stream().filter(x -> x.getPatente().equals(patente)).findFirst().orElse(null);

        if (moto != null)
            socorrerMoto.socorrer(moto);
        else
            System.out.println("No se encontro la moto: " + patente);
    }

}
