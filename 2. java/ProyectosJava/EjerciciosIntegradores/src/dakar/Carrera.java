package dakar;

import java.util.List;

public class Carrera {

    private long distancia;
    private long premioEnDolares;
    private long nombre;
    private long cantDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaMoto sMotos;
    private SocorristaAuto sAutos;


    public void darDeAltaAuto(double velocidad,double aceleracion,double anguloDeGiro, String patente){
        agreegar control con el la cantidad de vehiculos

        Vehiculo auto = new Auto(velocidad,aceleracion,anguloDeGiro,patente);
        this.listaDeVehiculos.add(auto);

    }

    public void darDeAltaMoto(double velocidad,double aceleracion,double anguloDeGiro, String patente){
        Vehiculo moto = new Moto(velocidad,aceleracion,anguloDeGiro,patente);
        this.listaDeVehiculos.add(moto);


    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    };
    public void eliminarVehiculoConPatente(String unaPatente){

        boolean bandera = true;
        for (Vehiculo v: listaDeVehiculos) {
            bandera = false;
            if (v.getPatente().equals(unaPatente))listaDeVehiculos.remove(v);
        }
        if (bandera) System.out.println("No se ha encontrado la patente");
    };

    public void definirGanador(){

        Vehiculo ganador;
        double mejorPuntaje = 0;

        for (Vehiculo v: listaDeVehiculos){
            double puntaje = v.getVelocidad()*(v.getAceleracion()/2)/(v.getAnguloDeGiro()*(v.getPeso()-v.getRuedas()*100));
            if(puntaje>mejorPuntaje) {
                mejorPuntaje=puntaje;
                ganador = v;
            }
        }

    };

    public void socorrerAuto(String patente){
        System.out.println("Socorriendo auto: "+patente);
    }

    public void socorrerMoto(String patente){
        System.out.println("Socorriendo moto: "+patente);
    }



}
