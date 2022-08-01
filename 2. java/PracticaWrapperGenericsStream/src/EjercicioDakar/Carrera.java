package EjercicioDakar;

import java.util.List;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    List<Vehiculo> vehiculos;
    SocorristaAuto socAuto;
    SocorristaMoto socMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadVehiculosPermitidos, List<Vehiculo> vehiculos, SocorristaAuto socAuto, SocorristaMoto socMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.socAuto = socAuto;
        this.socMoto = socMoto;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, int anguloDeGiro, String patente){
        if(this.vehiculos.size() < this.cantidadVehiculosPermitidos){
            Vehiculo auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
            vehiculos.add(auto);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, int anguloDeGiro, String patente){
        if(this.vehiculos.size() < this.cantidadVehiculosPermitidos){
            Vehiculo moto = new Auto(velocidad, aceleracion, anguloDeGiro, patente, 300, 2);
            vehiculos.add(moto);
        }
    }

    public void eliminarVehiculo(Vehiculo v){
        vehiculos.remove(v);
    }

    public void eliminarVehiculoConPatente(String patente){
        Vehiculo v = vehiculos.stream().filter(x -> x.getPatente().equals(patente)).findFirst().orElse(null);

        if(v != null)
            eliminarVehiculo(v);
    }

    public void socorrerAuto(String patente){
        Vehiculo v = vehiculos.stream().filter(x -> x.getPatente().equals(patente)).findFirst().orElse(null);

        if(v != null)
            socAuto.socorrer((Auto)v);
    }

    public void socorrerMoto(String patente){
        Vehiculo v = vehiculos.stream().filter(x -> x.getPatente().equals(patente)).findFirst().orElse(null);

        if(v != null)
            socMoto.socorrer((Moto)v);
    }

    public Vehiculo getGanador(){
        Vehiculo ganador = null;
        double max = 0;

        for(Vehiculo v: vehiculos){
            double velocidad = (v.getVelocidad() * (v.getAceleracion() * 0.5) / (v.getAnguloDeGiro()*(v.getPeso() - (v.getRuedas() * 100))));
            if(velocidad > max) {
                ganador = v;
                max = velocidad;
            }
        }

        return ganador;
    }
}
