package eip2vivo.Dakar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {

    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaVehiculo;
    private SoccoristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;



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

    public Integer getCantidadDeVehiculosPermitidos() {
        return this.cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculo() {
        return this.listaVehiculo;
    }

    public void setListaVehiculo(List<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

    public SoccoristaAuto getSoccoristaAuto() {
        return this.socorristaAuto;
    }

    public void setSoccoristaAuto(SoccoristaAuto soccoristaAuto) {
        this.socorristaAuto = soccoristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return this.socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public Carrera(double distancia, double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaVehiculo = new ArrayList<>();
    }

    public void darDeAltaAuto( Integer velocidad, Integer aceleracion, double angulodeGiro, String patente) {
        if(this.listaVehiculo.size() < this.cantidadDeVehiculosPermitidos) {
            Autos auto = new Autos(velocidad, aceleracion, angulodeGiro, patente);
            this.listaVehiculo.add(auto);
            System.out.println("El auto fue agregado exitosamente a la carrera!");

        }else{
            System.out.println("Lo sentimos, no quedan cupos disponibles!");
        }
    }

    public void darDeAltaMoto( Integer velocidad, Integer aceleracion, double angulodeGiro, String patente) {

        if(this.listaVehiculo.size() < this.cantidadDeVehiculosPermitidos) {
            Motos moto = new Motos(velocidad, aceleracion, angulodeGiro, patente);
            this.listaVehiculo.add(moto);
            System.out.println("La moto fue agregada exitosamente a la carrera!");

        }else{
            System.out.println("Lo sentimos, no quedan cupos disponibles!");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {

        if(this.listaVehiculo.contains(vehiculo)){
            this.listaVehiculo.remove(vehiculo);
            System.out.println("Vehiculo eliminado exitosamente!");
        }else{
            System.out.println("No se encontro el vehiculo que desea eliminar");
        }


    }

    public void eliminarVehiculoConPatente(String unaPatente) {

        this.listaVehiculo = this.listaVehiculo.stream()
                .filter(x -> !x.getPatente().equals(unaPatente)).collect(Collectors.toList());
        System.out.println("Vehiculo Eliminado exitosamente con su patente!");
    }

    public void getGanador() {
        List<Double> ganador = this.listaVehiculo.stream().map(x -> formulaGanador(x)).collect(Collectors.toList());
        int indiceGanador = ganador.indexOf(ganador.stream().max(Double::compare).get());
        System.out.println(this.listaVehiculo.get(indiceGanador));
    }



    public double formulaGanador(Vehiculo vehiculo) {
        return (vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2))
                / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
    }

    public void socorrerAuto(String patente) {
        Vehiculo vehiculo = this.listaVehiculo.stream()
                .filter(x -> x.getPatente().equals(patente)).findFirst().get();
        socorristaAuto.socorrer((Autos) vehiculo);
    }

    public void socorrerMoto(String patente) {
        Vehiculo vehiculo = this.listaVehiculo.stream()
                .filter(x -> x.getPatente().equals(patente)).findFirst().get();
        socorristaMoto.socorrer((Motos)vehiculo);
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", listaVehiculo=" + this.listaVehiculo.toString();
    }
}
