package ejercicio2.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {
    private float distancia;
    private float premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
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

    public Carrera(float distancia, float premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.listaDeVehiculos = new ArrayList<>();
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public float getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(float premioEnDolares) {
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

    @Override
    public String toString() {
        return "Carrera " + this.nombre + "\n" +
                "Distancia: " + this.distancia + "km. \n" +
                "Participantes: " + this.listaDeVehiculos.size() + "\n" +
                "Premio: U$S " + this.premioEnDolares;
    }

    public void darDeAltaAuto(float velocidad, float aceleracion, float anguloDeGiro, String patente){
        if (this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos){
            Auto autoParticipante = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            this.listaDeVehiculos.add(autoParticipante);
            System.out.println("Nuevo Auto agregado a la carrera " + this.nombre);
        }else{
            System.out.println("No se pudo agregar el Auto, no hay más cupos");
        }
    }
    public void darDeAltaMoto(float velocidad, float aceleracion, float anguloDeGiro, String patente){
        if (this.listaDeVehiculos.size() < this.cantidadDeVehiculosPermitidos){
            Moto motoParticipante = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            this.listaDeVehiculos.add(motoParticipante);
            System.out.println("Nueva Moto agregada a la carrera " + this.nombre);
        }else{
            System.out.println("No se pudo agregar la Moto, no hay más cupos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if (this.listaDeVehiculos.contains(vehiculo)){
            listaDeVehiculos.remove(vehiculo);
            System.out.println("Vehiculo con patente "+ vehiculo.getPatente() +" eliminado");
        }else{
            System.out.println("El Vehiculo con patente " + vehiculo.getPatente() + " no existe.");
        }
    }
    public void eliminarVehiculoConPatente(String patente){
        boolean removido = false;
        for (int i = 0; i < this.listaDeVehiculos.size(); i++) {
            if (this.listaDeVehiculos.get(i).getPatente() == patente){
                listaDeVehiculos.remove(i);
                removido = true;
                break;
            }
        }

        if (removido){
            System.out.println("Vehiculo con patente "+ patente +" eliminado");
        }else{
            System.out.println("El Vehiculo con patente " + patente + " no existe.");
        }
    }

    public Vehiculo definirGanador(){
        Vehiculo vehiculoGanador = this.listaDeVehiculos.get(0);
        float valorActual = 0;
        float valorAnterior = 0;

        for (Vehiculo veh : this.listaDeVehiculos){
            valorActual = ((veh.getVelocidad()*(veh.getAceleracion()/2))/(veh.getAnguloDeGiro()*(veh.getPeso()-veh.getRuedas()*100)));
            if (valorActual > valorAnterior){
                valorAnterior = valorActual;
                vehiculoGanador = veh;
            }
        }

        if (vehiculoGanador instanceof Auto){
            System.out.println("El vehiculo ganador es un Auto ("+vehiculoGanador.getPatente()+")! y ganó U$S" + this.premioEnDolares);
            vehiculoGanador.toString();
        }else{
            System.out.println("El vehiculo ganador es una Moto Auto ("+vehiculoGanador.getPatente()+")! y ganó U$S" + this.premioEnDolares);
            vehiculoGanador.toString();
        }
        return vehiculoGanador;
    }

    public void socorrerAuto(String patente){
        Auto autoASocorrer = null;
        for (int i = 0; i < this.listaDeVehiculos.size(); i++) {
            if (this.listaDeVehiculos.get(i).getPatente() == patente){
                if(this.listaDeVehiculos.get(i) instanceof Auto){
                    autoASocorrer = (Auto)listaDeVehiculos.get(i);
                }
                break;
            }
        }

        if (autoASocorrer != null){
            socorristaAuto.socorrer(autoASocorrer);
        }else{
            System.out.println("El Auto con patente " + patente + " no existe. No se puede socorrer.");
        }
    }
    public void socorrerMoto(String patente){
        Moto motoASocorrer = null;
        for (int i = 0; i < this.listaDeVehiculos.size(); i++) {
            if (this.listaDeVehiculos.get(i).getPatente() == patente){
                if(this.listaDeVehiculos.get(i) instanceof Moto){
                    motoASocorrer = (Moto) listaDeVehiculos.get(i);
                }
                break;
            }
        }

        if (motoASocorrer != null){
            socorristaMoto.socorrer(motoASocorrer);
        }else{
            System.out.println("La moto con patente " + patente + " no existe. No se puede socorrer.");
        }
    }
}
