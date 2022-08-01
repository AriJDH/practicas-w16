package Dakar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private Integer Distancia;
    private Integer PremioEnDolares;
    private String Nombre;
    private Integer CantidadDeVehiculosPermitido;
    private List<Vehiculo> ListaVehiculo;
    private SocorristaAuto socorristaAuto = new SocorristaAuto();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Carrera(Integer distancia, Integer premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitido ) {
        Distancia = distancia;
        PremioEnDolares = premioEnDolares;
        Nombre = nombre;
        CantidadDeVehiculosPermitido = cantidadDeVehiculosPermitido;
        ListaVehiculo = new ArrayList<>();
    }

    public void darDeAltaAuto(Integer velocidad, Integer aceleracion, Double AnguloDeGiro, String patente){
        if(validarCantidadVehiculo())
        {
            ListaVehiculo.add(new Vehiculo(velocidad, aceleracion, AnguloDeGiro, patente, 1000, 4, eCategoria.Auto));
        }else
            System.out.println("La carrera no permite más participantes");


    }

    public void darDeAltaMoto(Integer velocidad, Integer aceleracion, Double AnguloDeGiro, String patente){
        if(validarCantidadVehiculo())
        {
            ListaVehiculo.add(new Vehiculo(velocidad, aceleracion, AnguloDeGiro, patente, 300, 2, eCategoria.Moto));

        }else
            System.out.println("La carrera no permite más participantes");
    }
    public void eliminarVehiculo(Vehiculo vehiculo){
        ListaVehiculo.remove(vehiculo);
    }
    public void eliminarVehiculoConPatente(String unaPatente){
        Optional<Vehiculo> v = ListaVehiculo.stream().filter(l -> l.getPatente().equals(unaPatente)).findFirst();
        if(v.isPresent())
        {
            ListaVehiculo.remove(v.get());
        }
    }

    public void socorrerAuto(String patente){
        Vehiculo v = new Vehiculo(patente);
        socorristaAuto.socorrer(v);
    }
    public void socorrerMoto(String patente){
        Vehiculo v = new Vehiculo(patente);
        socorristaMoto.socorrer(v);
    }

    private void Ganador()
    {
        String patente = "";
        Double resultado = 0.0;
        boolean primero = true;

        for (Vehiculo v : ListaVehiculo)
        {
            if (primero) {
                resultado = Double.valueOf(Calculo(v));
                patente =v.getPatente();
            }
            else {
                double calculo = Calculo(v);
                if (calculo < resultado) {
                    resultado = calculo;
                    patente =v.getPatente();
                }
            }
        }
        System.out.println("Ganador es : "+patente);
    }

    private boolean validarCantidadVehiculo(){
        boolean valido = true;

        if(ListaVehiculo.stream().count() >= CantidadDeVehiculosPermitido)
                valido = false;

        return valido;

    }

    private Double Calculo(Vehiculo v)
    {
        Double primero = Double.valueOf(v.getVelocidad()*(v.getAceleracion()/2)/(v.getAnguloDeGiro()*(v.getPeso()- v.getRueda()*100)));
        return primero;
    }
}
