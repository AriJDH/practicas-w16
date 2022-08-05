package com.bootcamp.clases;

import java.util.List;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;


    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
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

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }


    public void darDeAltaAuto(Double velocidad, Double aceleracion, Integer anguloDeGiro, String patente) {
        if (this.vehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(auto);
            System.out.println("Se dio de alta el vehiculo: " + patente);
        }else{
            System.out.println("Hubo un error al dar de alta el vehiculo: " + patente);
        }

    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Integer anguloDeGiro, String patente) {
        if (this.vehiculos.size() < this.cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(moto);
            System.out.println("Se dio de alta el vehiculo: " + patente);
        }
        System.out.println("Hubo un error al dar de alta el vehiculo: " + patente);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.removeIf(v -> vehiculo.getPatente().equals(v.getPatente()));
    }

    public void eliminarVehiculoConPatente(String patente) {
        this.vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public void socorrerAuto(String patente) {
        System.out.println("Socorriendo auto");
    }

    public void socorrerMoto(String patente) {
        System.out.println("Socorriendo moto");
    }

    //Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
    public Vehiculo definirGanador() {
        Vehiculo ganador= null;
        Double maximo = 0d;
        Double vehiculoActual = 0d;
        for (Vehiculo vehiculo : this.vehiculos) {
            vehiculoActual = (vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2))/
                    (vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100));
            if (vehiculoActual > maximo) {
                ganador= vehiculo;
                maximo = vehiculoActual;
            }

        }
        return ganador;
    }

}
