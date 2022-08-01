package dakar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(){}

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.listaVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
       Vehiculo vehiculoABorrar = listaVehiculos.stream().filter(vehiculo -> vehiculo.patente.equals(patente)).findFirst().get();
       listaVehiculos.remove(vehiculoABorrar);
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloGiro, String patente){
        if(listaVehiculos.size() < cantidadVehiculosPermitidos){
            listaVehiculos.add(new Moto(velocidad, aceleracion, anguloGiro, patente ));
            System.out.println("Moto agregada correctamente");
        }else {
            System.out.println("No hay cupos disponibles para esta carrera");
        }
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloGiro, String patente){
        if(listaVehiculos.size() < cantidadVehiculosPermitidos){
            listaVehiculos.add(new Auto(velocidad, aceleracion, anguloGiro, patente));
            System.out.println("Auto agregada correctamente");
        }else {
            System.out.println("No hay cupos disponibles para esta carrera");
        }
    }

    public void socorrerAuto(String patente){

       var auto = listaVehiculos.stream().filter(vehiculo -> vehiculo.patente.equals(patente)).findFirst();

        if(auto.isPresent()){
            socorristaAuto.socorrer(auto.get());
        }else {
            System.out.println("Auto no encontrado");
        }
    }

    public void socorrerMoto(String patente){

        var moto = listaVehiculos.stream().filter(moto1 -> moto1.patente.equals(patente)).findFirst();

        if(moto.isPresent()){
            socorristaMoto.socorrer(moto.get());
        }else {
            System.out.println("Auto no encontrado");
        }
    }

    public void definirGanador(){

      Vehiculo vehiculoGanador =  listaVehiculos.stream().max((Comparator.comparing(vehiculo -> calcularFormulaGanador(vehiculo)))).get();

        System.out.println("El ganador de la carrera es el vehiculo: " + vehiculoGanador.patente);
    }


    public double calcularFormulaGanador(Vehiculo vehiculo){
        return (vehiculo.velocidad * (vehiculo.aceleracion/2)) / (vehiculo.anguloDeGiro * (vehiculo.peso - vehiculo.ruedas * 100));
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

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }
}
