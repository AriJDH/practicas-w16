package EjerciciosIntegradoresP2.Dakar.actors;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto(0, 0, 0, "AAA111");
        this.socorristaMoto = new SocorristaMoto(0, 0, 0, "BBB222");
    }

    public double getDistancia() {
        return this.distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return this.premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return this.cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public boolean darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(this.vehiculos.size() < this.cantidadDeVehiculosPermitidos){
            this.vehiculos.add(new Moto(aceleracion, velocidad, anguloDeGiro, patente));
            return true;
        }
        return false;
    }

    public boolean darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(this.vehiculos.size() < this.cantidadDeVehiculosPermitidos){
            this.vehiculos.add(new Auto(aceleracion, velocidad, anguloDeGiro, patente));
            return true;
        }
        return false;
    }

    public boolean eliminarVehiculoConPatente(String patente){
        for(Vehiculo vehiculo : this.vehiculos){
            if(vehiculo.getPatente().equals(patente)){
                this.vehiculos.remove(vehiculo);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarVehiculo(Vehiculo vehiculo){
        if(this.vehiculos.contains(vehiculo)){
            this.vehiculos.remove(vehiculo);
            return true;
        }
        return false;
    }

    public Vehiculo getGanador(){
        Vehiculo winner = null;

        for(Vehiculo vehiculo : this.vehiculos){
            if(winner == null){
                winner = vehiculo;
            }
            else if(winner.getVelocidad() < vehiculo.getVelocidad()){
                winner = vehiculo;
            }
        }

        return winner;
    }

    public void socorrerMoto(String patente){
        for(Vehiculo vehiculo : this.vehiculos){
            if(vehiculo.getPatente().equals(patente)){
                this.socorristaMoto.socorrer((Moto) vehiculo);
            }
        }
    }

    public void socorrerAuto(String patente){
        for(Vehiculo vehiculo : this.vehiculos){
            if(vehiculo.getPatente().equals(patente)){
                this.socorristaAuto.socorrer((Auto) vehiculo);
            }
        }
    }

}
