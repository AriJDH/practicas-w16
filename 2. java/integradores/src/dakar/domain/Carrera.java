package dakar.domain;

import dakar.interfaces.Socorrista;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos = new ArrayList<>();
    private Socorrista socorristaAuto = new SocorristaAuto();
    private Socorrista socorristaMoto = new SocorristaMoto();

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
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

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public Socorrista getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(Socorrista socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public Socorrista getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(Socorrista socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaAuto(int velocidad, double aceleracion, double AnguloDeGiro, String patente) {
        if (hayCuposDisponbles())
            listaDeVehiculos.add(
                    new Auto(velocidad, aceleracion, AnguloDeGiro, patente)
            );
    }

    public void darDeAltaMoto(int velocidad, double aceleracion, double AnguloDeGiro, String patente) {
        if (hayCuposDisponbles())
            listaDeVehiculos.add(
                    new Moto(velocidad, aceleracion, AnguloDeGiro, patente)
            );
    }

    public boolean hayCuposDisponbles() {
        return this.listaDeVehiculos.size() < cantidadDeVehiculosPermitidos;
    }

    public void eliminarVehiculo(Vehiculo vehículo) {
        listaDeVehiculos.remove(vehículo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        listaDeVehiculos.removeIf(
                (vehiculo -> vehiculo.getPatente().equalsIgnoreCase(unaPatente))
        );
    }

    public void socorrerAuto(String patente){
        socorristaAuto.socorer(buscarVehiculo(patente));
    }

    public void socorrerMoto(String patente){
        socorristaMoto.socorer(buscarVehiculo(patente));
    }

    public Vehiculo buscarVehiculo(String patente){
        Vehiculo vehiculoBuscado = listaDeVehiculos
                .stream()
                .filter(vehiculo -> vehiculo.getPatente().equalsIgnoreCase(patente))
                .findFirst()
                .get();
        return vehiculoBuscado;
    }

    public Optional<Vehiculo> obtenerGanador(){
        return listaDeVehiculos.stream().max(Comparator.comparing(Vehiculo::getValorUnico));
    }


}
