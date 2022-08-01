package EjerciciosIntegradores_Java.Ejercicio_Dakar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
        this.listaVehiculos = new ArrayList<>();
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
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

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", listaVehiculos=" + listaVehiculos +
                ", socorristaAuto=" + socorristaAuto +
                ", socorristaMoto=" + socorristaMoto +
                '}';
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){

        if(this.listaVehiculos.size() < this.cantidadDeVehiculosPermitidos){
            listaVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
            System.out.println("El auto fue inscrito correctamente");
        } else {
            System.out.println("Ya no hay cupos disponibles para esta carrera.");
        }

    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){

        if(this.listaVehiculos.size() < this.cantidadDeVehiculosPermitidos){
            listaVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
            System.out.println("El auto fue inscrito correctamente");
        } else {
            System.out.println("Ya no hay cupos disponibles para esta carrera.");
        }

    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if(listaVehiculos.remove(vehiculo)){
            System.out.println("Vehiculo removido exitosamente por objeto");
        } else {
            System.out.println("Error removiendo el vehiculo por objeto");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        if(listaVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente))){
            System.out.println("Vehiculo removido exitosamente por patente.");
        } else {
            System.out.println("Error removiendo el vehiculo por patente.");
        }
    }

    public void definirGanador(){

        Vehiculo ganador = new Vehiculo();
        Double cuenta = 0.0;

        for(Vehiculo veh : listaVehiculos){
            Double cuentaInterior = (veh.getVelocidad() * (0.5 * veh.getAceleracion()))/(veh.getAnguloDeGiro() * (veh.getPeso() - (veh.getRuedas() * 100)));
            if(cuentaInterior >= cuenta){
                ganador = veh;
                cuenta = cuentaInterior;
            }
        }

        System.out.println(ganador);
    }

    public void socorrerAuto(String patente){
        socorristaAuto.socorrer(new Auto(null,null, null, patente));
    }

    public void socorrerMoto(String patente){
        socorristaMoto.socorrer(new Moto(null,null, null, patente));
    }

}
