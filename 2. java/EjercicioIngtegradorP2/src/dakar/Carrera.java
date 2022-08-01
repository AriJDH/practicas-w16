package dakar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Carrera {
    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private Set<Vehiculo> listaVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;
    private Vehiculo vehiculo;

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.listaVehiculos = new HashSet<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadVehiculosPermitidos=" + cantidadVehiculosPermitidos +
                ", listaVehiculos=" + listaVehiculos +
                '}';
    }

    public void darDeAltaAuto(int velocidad,int aceleracion,int anguloDeGiro,String patente){
        if (hayCupo()){
            vehiculo = new Auto(velocidad,aceleracion,anguloDeGiro,patente);
            boolean agregadoCorrectamente = listaVehiculos.add(vehiculo);
            if (agregadoCorrectamente){
                System.out.println("Auto Agregado Exitosamente");
            }else {
                System.out.println("Auto Ya Existe");
            }
        }else{
            System.out.println("No Hay Mas Cupo");
        }
    }

    public void darDeAltaMoto(int velocidad,int aceleracion,int anguloDeGiro,String patente){
        if (hayCupo()){
            vehiculo = new Moto(velocidad,aceleracion,anguloDeGiro,patente);
            boolean agregadoCorrectamente = listaVehiculos.add(vehiculo);
            if (agregadoCorrectamente){
                System.out.println("Moto Agregada Exitosamente");
            }else {
                System.out.println("Moto Ya Existe");
            }
        }else{
            System.out.println("No Hay Mas Cupo");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if(listaVehiculos.contains(vehiculo)){
            System.out.println("Vehiculo Eliminado");
            listaVehiculos.remove(vehiculo);
        }else{
            System.out.println("El Vehiculo no Existe No Se Pudo Eliminar");
        }

    }

    public void eliminarVehiculoConPatente(String patente) {
        boolean bandera = false;
        Vehiculo vehiculoRemover;
        for (Vehiculo vehiculo: listaVehiculos) {
            if(vehiculo.getPatente().equals(patente)){
                vehiculoRemover=vehiculo;

            }
        }
        if(bandera){
            bandera=listaVehiculos.remove(vehiculo);
            System.out.println("Vehiculo Eliminado con Patente");

        }else{
            System.out.println("El Vehiculo No Esta Inscrito");
        }
    }

    public void ganador(){
        double valorMaximo=0;
        double formula;
        Vehiculo vehiculoGanador=null;
        for (Vehiculo vehiculo: listaVehiculos
             ) {
            formula = (vehiculo.getVelucidad()*0.5*vehiculo.getAceleracion())/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100));
            if(formula>valorMaximo){
                vehiculoGanador=vehiculo;
            }
        }

        System.out.println("El Ganador Es: "+vehiculoGanador.toString());
    }

    public void socorrerAuto(String patente){
        boolean bandera=false;
        for (Vehiculo vehiculo: listaVehiculos) {
            if(vehiculo.getPatente().equals(patente)){
                bandera=true;
                socorristaAuto.socorrer(vehiculo);
            }
        }
        if(!bandera){
            System.out.println("El Auto No Esta Inscrito No Se Pudo Socorrer");
        }
    }

    public void socorrerMoto(String patente){
        boolean bandera=false;
        for (Vehiculo vehiculo: listaVehiculos) {
            if(vehiculo.getPatente().equals(patente)){
                socorristaMoto.socorrer(vehiculo);
            }
        }
        if(!bandera){
            System.out.println("La Moto No Esta Inscrita No se Pudo Socorrer");
        }
    }

    public boolean hayCupo(){
        return cantidadVehiculosPermitidos>listaVehiculos.size();
    }

}
