package Vehiculos;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

public class Carrera {
    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorroAuto;
    private SocorristaMoto socorroMoto;

    public Carrera() {
    }

    public Carrera(double distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos,
                   List<Vehiculo> listaDeVehiculos, SocorristaAuto socorroAuto, SocorristaMoto socorroMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
        this.socorroAuto = socorroAuto;
        this.socorroMoto = socorroMoto;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(int premioEnDolares) {
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

    public SocorristaAuto getSocorroAuto() {
        return socorroAuto;
    }

    public void setSocorroAuto(SocorristaAuto socorroAuto) {
        this.socorroAuto = socorroAuto;
    }

    public SocorristaMoto getSocorroMoto() {
        return socorroMoto;
    }

    public void setSocorroMoto(SocorristaMoto socorroMoto) {
        this.socorroMoto = socorroMoto;
    }

    //Método que agrega autos a la carrera
    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (this.cantidadDeVehiculosPermitidos >= this.listaDeVehiculos.size()){
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            this.listaDeVehiculos.add(auto);
        }
        else{
            System.out.println("No es posible inscribir más vehículos a la carrera");
        }
    }

    //Método que agrega motos a la carrera
    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (this.cantidadDeVehiculosPermitidos >= this.listaDeVehiculos.size()) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            this.listaDeVehiculos.add(moto);
        }
        else{
            System.out.println("No es posible inscribir más vehículos a la carrera");
        }
    }

    //Método que elimina un vehículo señalando el mismo
    public void eliminarVehiculo(Vehiculo vehiculo){
        try {
            Vehiculo vehiculoAux = this.listaDeVehiculos.stream()
                    .filter(vehiculo1 -> vehiculo1.getPatente().equals(vehiculo.getPatente()))
                    .findFirst()
                    .get();
            this.listaDeVehiculos.remove(vehiculoAux);
        }
        catch(NoSuchElementException e){
            System.out.println("No se encontró el vehículo ingresado");
        }
    }

    //Método que elimina un vehículo señalando la patente
    public void eliminarVehiculoConPatente(String unaPatente){
        try {
            Vehiculo vehiculoAux = this.listaDeVehiculos.stream()
                    .filter(vehiculo -> unaPatente.equals(vehiculo.getPatente()))
                    .findFirst()
                    .get();
            this.listaDeVehiculos.remove(vehiculoAux);
        }
        catch(NoSuchElementException e){
            System.out.println("No se encontró la patente ingresada");
        }
    }

    //Método que devuelve el vehículo ganador de la carrera
    public Vehiculo definirGanador(){
        ArrayList<Double> arregloDeCalculo = new ArrayList<>();
        double calculo;
        for (Vehiculo vehiculos: this.listaDeVehiculos){
            calculo = (vehiculos.getVelocidad() * vehiculos.getAceleracion()/2)
                    /(vehiculos.getAnguloDeGiro()*(vehiculos.getPeso()-vehiculos.getRuedas()));
            arregloDeCalculo.add(calculo);
        }
        int posicionMayor = IntStream.range(0, arregloDeCalculo.size())
                .reduce((a,b)->arregloDeCalculo.get(a) < arregloDeCalculo.get(b)? b: a)
                .getAsInt();

        return this.listaDeVehiculos.get(posicionMayor);
    }

    //Método que envía a un socorrista de auto a socorrer un auto según su patente
    public void socorrerAuto(String patente){
        try {
            ArrayList<Auto> seleccionAutos = new ArrayList<>();
            for (int i = 0; i < this.listaDeVehiculos.size(); i++) {
                if (this.listaDeVehiculos.get(i).getRuedas() == 4) {
                    seleccionAutos.add((Auto) listaDeVehiculos.get(i));
                }
            }
            Auto autoAux = seleccionAutos.stream()
                    .filter(auto -> patente.equals(auto.getPatente()))
                    .findFirst()
                    .get();

            this.socorroAuto.socorrerAuto(autoAux);
        }
        catch(NoSuchElementException e){
            System.out.println("El auto ingresado no se encuentra en la carrera");
        }
    }

    //Método que envía a un socorrista de moto a socorrer una moto según su patente
    public void socorrerMoto(String patente){
        try {
            ArrayList<Moto> seleccionMotos = new ArrayList<>();
            for (int i = 0; i < this.listaDeVehiculos.size(); i++) {
                if (this.listaDeVehiculos.get(i).getRuedas() == 2) {
                    seleccionMotos.add((Moto) listaDeVehiculos.get(i));
                }
            }

            Moto motoAux = seleccionMotos.stream()
                    .filter(moto -> patente.equals(moto.getPatente()))
                    .findFirst()
                    .get();

            this.socorroMoto.socorrerMoto(motoAux);
        }
        catch(NoSuchElementException e){
            System.out.println("La moto ingresada no se encuentra en la carrera");
        }
    }
}
