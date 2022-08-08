package Dakar;

import java.util.ArrayList;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private ArrayList<Vehiculo> listaDeVehiculos;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera() {
    }

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        this.listaDeVehiculos.add(auto);
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        this.listaDeVehiculos.add(moto);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        this.listaDeVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public void definirGanador() {
        // Recorrer lista y calcular val maximo. Guardar vehiculo máximo. Retornarlo en forma de String
        Double maxVal = 0.0;
        Vehiculo ganador = new Auto();
        for (Vehiculo vehiculo : this.listaDeVehiculos) {
            Double valorFormula = vehiculo.getVelocidad()*0.5*vehiculo.getAceleracion()/(
                    vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100)
                    );
            if (valorFormula > maxVal) {
                maxVal = valorFormula;
                ganador = vehiculo;
            }
        }
        System.out.println(ganador);
    }

    public void socorrerAuto(String patente) {
        socorristaAuto.socorrer((Auto) this.listaDeVehiculos.stream()
                                .filter(auto -> auto.getPatente().equals(patente)));
    }
    public void socorrerMoto(String patente) {
        socorristaMoto.socorrer((Moto) this.listaDeVehiculos.stream()
                .filter(moto -> moto.getPatente().equals(patente)));
    }
}
