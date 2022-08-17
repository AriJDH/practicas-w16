import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    List<Vehiculo> listaDeVehiculos;

    public Carrera() {
        listaDeVehiculos = new ArrayList<>();

    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
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

    public Boolean verificarCupo(){
        int cupo = this.cantidadDeVehiculosPermitidos - listaDeVehiculos.size();
        if(cupo<0){
            return false;
        }
        return true;
    }

    public void darDeAltaAuto(int velocidad, int aceleracion, int angulo, String patente) {
        if(verificarCupo()){
            Autos auto= new Autos(velocidad,aceleracion,angulo,patente);
            this.listaDeVehiculos.add(auto);
            System.out.println("\nInscripción de auto exitosa: " + patente);
        }else{
            System.out.println("\nNo quedan cupos disponibles para el auto: " + patente);
        }
    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int angulo, String patente) {
        if(verificarCupo()){
            Motos moto= new Motos(velocidad,aceleracion,angulo,patente);
            this.listaDeVehiculos.add(moto);
            System.out.println("\nInscripción de moto exitosa: " + patente);
        }else{
            System.out.println("\nNo quedan cupos disponibles para la moto: " + patente);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {

    }

    public void eliminarVehiculo(String patente) {
        Vehiculo eliminar = null;
        for(Vehiculo vehiculos : listaDeVehiculos){
            if(vehiculos.getPatente().equals(patente)){
                eliminar =  vehiculos;
            }
        }
        if(eliminar!=null){
            listaDeVehiculos.remove(eliminar);
            System.out.println("\nVehículo " + patente + " eliminado");
        }else{
            System.out.println("\nNo pudo eliminarse el vehículo: " + patente);
        }
    }

    public void vehiculoGanador(){

        double ganador = 0;
        String patenteGanadora="";
        System.out.println("\nCalculando Ganador...");
        for(Vehiculo veh : listaDeVehiculos){
            double calculo = (veh.getVelocidad()* (veh.getAceleracion()/2) )/ (veh.getAnguloDeGiro()*(veh.getPeso() - (veh.getRuedas()*100)) )   ;
            System.out.println(calculo);
            if(calculo>ganador){
                ganador = calculo;
                patenteGanadora = veh.getPatente();
            }
        }
        System.out.println("\nEl vehículo GANADOR es : " + patenteGanadora + " con un cálculo = " + ganador);
    }

    public void socorrerAuto(String patente){
        for(Vehiculo auto: listaDeVehiculos){

            if(auto.getPatente().equals(patente)) {
                //socorrer(auto);
            }

            }

    }

    public void socorrerMoto(String patente){

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
}