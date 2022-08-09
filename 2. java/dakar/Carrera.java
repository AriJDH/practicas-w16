package dakar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {
    private Integer distancia;
    private Integer premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;
    private ISocorrista<Moto> socorritaMoto;
    private ISocorrista<Auto> socorristaAuto;

    public Carrera(Integer distancia, Integer premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, ISocorrista<Moto> socorritaMoto, ISocorrista<Auto> socorristaAuto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculos = new ArrayList<>();
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Integer getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Integer premioEnDolares) {
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

    public void darDeAltaAuto(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente) {
        this.listaVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(Integer velocidad, Integer aceleracion, Integer anguloDeGiro, String patente) {
        this.listaVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.listaVehiculos.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String patente) {
        this.listaVehiculos = listaVehiculos.stream().filter(vehiculo -> !vehiculo.getPatente().contentEquals(patente)).collect(Collectors.toList());
    }

    public Vehiculo ganador() {
        return this.listaVehiculos.stream().max(Comparator.comparing(vehiculo -> vehiculo.getWinScore())).get();
    }
    public void socorrerAuto(String patente) {
        Vehiculo auto = this.findByPatente(patente);
        if(auto.equals(null) || !(auto instanceof Auto)) {
            System.out.println("No es un auto");
            return;
        }
        this.socorristaAuto.socorrer((Auto) auto);
    }
    public void socorrerMoto(String patente) {
        Vehiculo moto = this.findByPatente(patente);
        if(moto.equals(null) || !(moto instanceof Moto)) {
            System.out.println("No es una motoº");
            return;
        }
        this.socorritaMoto.socorrer((Moto) moto);
    }
    public Vehiculo findByPatente(String patente) {
        return this.listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst()
                .orElse(null);
    }
}
