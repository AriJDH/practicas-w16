package ejercicio2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Carrera {

    double distancia;
    int premioEnDolares;
    String nombre;
    int cantidadDeVehiculosPermitidos;
    List<Vehiculo> listaDeVehiculos = new ArrayList<>();
    VehiculoSocorrista socorristaMoto;
    VehiculoSocorrista socorristaAuto;


    public Carrera(double distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.socorristaMoto = new SocorristaMoto();
        this.socorristaAuto = new SocorristaAuto();
    }

    public void darAltaVehiculo(Vehiculo vehiculo){
        if(this.cantidadDeVehiculosPermitidos > listaDeVehiculos.size()){
            listaDeVehiculos.add(vehiculo);
            System.out.println("Se agrego el vehiculo");
        }else {
            System.out.println("No se agrego el vehiculo");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        this.eliminarVehiculoConPatente(vehiculo.getPatente());
    }

    public void eliminarVehiculoConPatente(String unaPatente){
      /*this.listaDeVehiculos.removeIf(vehiculo -> vehiculo.patente.equals(unaPatente));
        //Vehiculo vehiculoRemover = (Vehiculo) listaDeVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(unaPatente)).;
       // System.out.println(unaPatente);
        //boolean result = listaDeVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals("10"));
        //System.out.println(result);*/

        listaDeVehiculos = listaDeVehiculos.stream()
                .filter(vehiculo -> !unaPatente.equals(vehiculo.getPatente()))
                .collect(Collectors.toList());
        System.out.println(listaDeVehiculos);
    }

    public Vehiculo definirGanador(){
        Vehiculo ganador = listaDeVehiculos.stream().max(Comparator.comparing(vehiculo -> (vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2)) / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100)))).get();
        return ganador;
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

    public void socorrer(String patente){

        List<Vehiculo> lista = this.listaDeVehiculos.stream().filter(vehiculo -> vehiculo.patente.equals(patente)).collect(Collectors.toList());
        if (lista.size() != 0 ){
            if(lista.get(0).ruedas == 4){
                this.socorristaAuto.socorrer(patente);
            }else {
                this.socorristaMoto.socorrer(patente);
            }
        }else{
            System.out.println("No hay vehiculo con patente");
        }
    }



    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", listaDeVehiculos=" + listaDeVehiculos +
                ", socorristaMoto='" + socorristaMoto + '\'' +
                ", socorristaAuto='" + socorristaAuto + '\'' +
                '}';
    }
}
