package ejerciciosIntegradoresP2Vivo.Dakar;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private int distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(int distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(double velocidad,double aceleracion,double anguloDeGiro,String patente){
        if(listaDeVehiculos.size()<cantidadDeVehiculosPermitidos){
            listaDeVehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
            System.out.println("Auto agregado a la carrera");
        }else{
            System.out.println("No es posible agregar el auto, la cantidad de vehiculos permitidos llego al méximo");
        }
    }

    public void darDeAltaMoto(double velocidad,double aceleracion,double anguloDeGiro,String patente){
        if(listaDeVehiculos.size()<cantidadDeVehiculosPermitidos){
            listaDeVehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
            System.out.println("Moto agregada a la carrera");
        }else{
            System.out.println("No es posible agregar el vehiculo, la cantidad de vehiculos permitidos llego al máximo");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        Vehiculo vehiculoEliminado = listaDeVehiculos.stream().
                filter(vehiculo1 -> vehiculo1.equals(vehiculo)).findFirst().get();
        if(listaDeVehiculos.remove(vehiculoEliminado)){
            System.out.println("El vehiculo con patente "+ vehiculoEliminado.getPatente() + " ha sido removido");
        }

    }

    public void eliminarVehiculoConPatente(String patente) {
        Vehiculo vehiculoEliminado = listaDeVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst().get();
        if (listaDeVehiculos.remove(vehiculoEliminado)) {
            System.out.println("El vehiculo con patente "+vehiculoEliminado.getPatente()+" ha sido eliminado ");
        }
    }

    public void revisar(){
        listaDeVehiculos.stream().forEach(System.out::println);
    }

    public void obtenerGanador(){
        Vehiculo vehiculoganardor = new Vehiculo();
        double maximo=0;
        for(Vehiculo vehiculo:listaDeVehiculos){
            double operacion = vehiculo.getVelocidad()*((vehiculo.getAceleracion()/2)/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100)));
            if(operacion>maximo){
                maximo=operacion;
                vehiculoganardor = vehiculo;
            }
        }
        System.out.println("El vehiculo ganador es: " + vehiculoganardor.getPatente());
    }

    public void socorrerAuto(String patente){
        Vehiculo vehiculo = listaDeVehiculos.stream()
                .filter(vehiculo1 -> vehiculo1.getPatente().equalsIgnoreCase(patente)).findFirst().get();
        socorristaAuto.socorrer((Auto)vehiculo);
    }

    public void socorrerMoto(String patente){
        Vehiculo vehiculo = listaDeVehiculos.stream()
                .filter(vehiculo1 -> vehiculo1.getPatente().equalsIgnoreCase(patente)).findFirst().get();
        socorristaMoto.socorrer((Moto) vehiculo);
    }
}
