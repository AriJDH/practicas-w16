package com.tomas.dakar;

import java.util.*;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantVehiculosPermitidos;
    private Map<String,Vehiculo> listaDeVehiculos;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantVehiculosPermitidos, Map<String, Vehiculo> listaDeVehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

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

    public int getCantVehiculosPermitidos() {
        return cantVehiculosPermitidos;
    }

    public void setCantVehiculosPermitidos(int cantVehiculosPermitidos) {
        this.cantVehiculosPermitidos = cantVehiculosPermitidos;
    }

    public Map<String,Vehiculo>  getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(Map<String,Vehiculo>  listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }


    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(listaDeVehiculos.size()<cantVehiculosPermitidos){
            Vehiculo auto = new Auto(velocidad,aceleracion,anguloDeGiro,patente);
            listaDeVehiculos.put(auto.getPatente(),auto);
            System.out.println("Agregado correctamente");
        }else{
            System.out.println("Ya se alcanzo el numero maximo de vehiculos");
        }

    }
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(listaDeVehiculos.size()<cantVehiculosPermitidos){
        Vehiculo moto = new Moto(velocidad,aceleracion,anguloDeGiro,patente);
        listaDeVehiculos.put(moto.getPatente(),moto);
            System.out.println("Agregado correctamente");
        }else{
            System.out.println("Ya se alcanzo el numero maximo de vehiculos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo.getPatente(),vehiculo);
    }
    public void eliminarVehiculoConPatente(String unaPatente){
        listaDeVehiculos.remove(unaPatente);
    }

    public void definirGanador(){
        double maxNumero = 0;
        String patenteGanador = "";
        List<Vehiculo> listaDeVehiculos1= new ArrayList<>(listaDeVehiculos.values());
        for(Vehiculo iter:listaDeVehiculos1){
            double valorCarrera = calcularValorCarrrera(iter);
            if (valorCarrera> maxNumero){
                maxNumero = valorCarrera;
                patenteGanador = iter.getPatente();
            }
        }
        System.out.println("El ganador es: "+ patenteGanador);
    }


    private double calcularValorCarrrera(Vehiculo vehiculo){
        return (vehiculo.getVelocidad()*(0.5)* vehiculo.getAceleracion())/
                (vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getCantRuedas()*100));
    }


    public void socorrerAuto(String patente){
        this.socorristaAuto.socorrerAuto((Auto)listaDeVehiculos.get(patente));
    }
    public void socorrerMoto(String patente){
        this.socorristaMoto.socorrerMoto((Moto)listaDeVehiculos.get(patente));
    }

}
