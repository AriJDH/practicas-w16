package integradores.integrador2.dakar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {

    private int distancia;
    private double premio;
    private String nombre;
    private int cantPermitidos;
    private List<Vehiculo> vehiculos;
    private Socorrista socorristaAuto;
    private Socorrista socorristaMoto;

    public Carrera(int distancia, double premio, String nombre, int cantPermitidos, Socorrista socorristaAuto, Socorrista socorristaMoto) {
        this.distancia = distancia;
        this.premio = premio;
        this.nombre = nombre;
        this.cantPermitidos = cantPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantPermitidos() {
        return cantPermitidos;
    }

    public void setCantPermitidos(int cantPermitidos) {
        this.cantPermitidos = cantPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
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


    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente){
        if (this.vehiculos.size() < cantPermitidos)
            this.vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        else
            System.out.println("Cupo máximo alcanzado");
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente){
        if (this.vehiculos.size() < cantPermitidos)
            this.vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        else
            System.out.println("Cupo máximo alcanzado");
    }

    public void eliminarVehiculo (Vehiculo v){
        if (this.vehiculos.contains(v))
            this.vehiculos.remove(v);
    }

    public void eliminarVehiculoConPatente(String patente){
        this.vehiculos = this.vehiculos.stream().filter(vehiculo -> !vehiculo.getPatente().equals(patente)).collect(Collectors.toList());
    }

    public void socorrerAuto(String patente){
        Vehiculo auto= this.vehiculos.stream().filter(vehiculo -> patente.equals(vehiculo.getPatente()))
                .findAny()
                .orElse(null);
        socorristaAuto.socorrer(auto);
    }


    public void socorrerMoto(String patente){
        Vehiculo moto= this.vehiculos.stream().filter(vehiculo -> patente.equals(vehiculo.getPatente()))
                .findAny()
                .orElse(null);

        socorristaMoto.socorrer(moto);
    }

    public Vehiculo obtenerGanador(){
        return this.vehiculos.stream().sorted(Comparator.comparing(Vehiculo :: getResultado)).findFirst().orElse(null);
    }



}
