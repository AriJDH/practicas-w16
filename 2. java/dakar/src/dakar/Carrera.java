package dakar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private final List<Vehiculo> listaVehiculos = new ArrayList<>();
    private final SocorristaAuto sa = new SocorristaAuto();
    private final SocorristaMoto sm = new SocorristaMoto();

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public void darDeAltaVehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(listaVehiculos.size() < cantidadVehiculosPermitidos)
            listaVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if(listaVehiculos.size() < cantidadVehiculosPermitidos)
            listaVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public Vehiculo ganador() {
        return listaVehiculos.stream()
                .max(Comparator.comparingDouble(v ->
                        v.getVelocidad()*v.getAceleracion()/(2*v.getAnguloDeGiro()*(v.getPeso()-100*v.getRuedas()))))
                .orElse(null);
    }

    public void socorrer(String patente) {
        Vehiculo vehiculo = listaVehiculos.stream().filter(v -> v.getPatente().equals(patente))
                .findFirst().orElse(null);
       if(vehiculo instanceof Auto)
           sa.socorrer((Auto) vehiculo);
       else if(vehiculo instanceof Moto)
           sm.socorrer((Moto) vehiculo);
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(int cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }
}
