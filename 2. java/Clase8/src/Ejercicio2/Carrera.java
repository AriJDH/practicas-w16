package Ejercicio2;

import java.util.List;
import java.util.Optional;

public class Carrera {
    protected Float distancia;
    protected Float premioEnDolares;
    protected String nombre;
    protected Integer cantidadDeVehiculosPermitidos;
    protected List<Vehiculo> listaDeVehiculos;
    protected SocorristaAuto socorristaAuto = new SocorristaAuto();
    protected SocorristaMoto socorristaMoto= new SocorristaMoto();


    public Carrera(Float distancia, Float premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, List<Vehiculo> listaDeVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
    }


    public void darDeAltaAuto(Integer velocidad, Float aceleracion, Float anguloDeGiro, String patente){
        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        listaDeVehiculos.add(auto);
    }

    public void darDeAltaMoto(Integer velocidad, Float aceleracion, Float anguloDeGiro, String patente){
        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        listaDeVehiculos.add(moto);
    }

    public void eliminarVehiculo(Vehiculo veh){
        listaDeVehiculos.remove(veh);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        Optional<Vehiculo> vehiculoABorrar = listaDeVehiculos.stream().filter(vehiculo -> vehiculo.patente.equals(unaPatente)).findFirst();
        if (vehiculoABorrar.isPresent()) {
            listaDeVehiculos.remove(vehiculoABorrar);
        }

        //listaDeVehiculos.stream().filter(vehiculo -> vehiculo.patente == unaPatente).forEach(vehiculo -> );

        listaDeVehiculos.removeIf(vehiculo -> vehiculo.patente.equals(unaPatente));
    }


    public Vehiculo obtGanador(){
        Vehiculo vehiculoGanador = new Auto();
        Float calculoGanador = 0f;


        for(Vehiculo vehiculo : listaDeVehiculos){

            Float calculo = (vehiculo.getVelocidad()*(vehiculo.getAceleracion()/2))/(vehiculo.getAnguloDeGiro()*(vehiculo.getPeso()-(vehiculo.getRuedas()*100)));

            if(calculo>calculoGanador){
                vehiculoGanador = vehiculo;
                calculoGanador = calculo;
            }


        };

        return vehiculoGanador;
    }

    public void socorrerAuto(String patente){
        Optional<Vehiculo> vehuculop = listaDeVehiculos.stream().filter(vehiculo -> vehiculo.patente.equals(patente)).findFirst();
        if(vehuculop.isPresent()){
            if(vehuculop.get() instanceof Auto){
                Auto auto = (Auto) vehuculop.get();
                socorristaAuto.socorrer(auto);
            }else{
                System.out.println("No existe auto con la patente especificada.");
            }
        } else{
            System.out.println("No existe vehiculo con la patente.");
        }
    }

    public void socorrerMoto(String patente){
        Optional<Vehiculo> vehuculop = listaDeVehiculos.stream().filter(vehiculo -> vehiculo.patente.equals(patente)).findFirst();
        if(vehuculop.isPresent()){
            if(vehuculop.get() instanceof Moto){
                Moto moto = (Moto) vehuculop.get();
                socorristaMoto.socorrer(moto);
            }else{
                System.out.println("No existe moto con la patente especificada.");
            }
        } else {
            System.out.println("No existe vehiculo con la patente.");
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
                '}';
    }




    public Float getDistancia() {
        return distancia;
    }

    public void setDistancia(Float distancia) {
        this.distancia = distancia;
    }

    public Float getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Float premioEnDolares) {
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

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }
}
