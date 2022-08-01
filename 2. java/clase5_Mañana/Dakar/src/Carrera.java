import java.util.Comparator;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premiosEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premiosEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premiosEnDolares = premiosEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
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

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente){
        Auto auto = new Auto (velocidad,aceleracion,anguloDeGiro,patente);
        if (vehiculos.size()<=this.cantidadDeVehiculosPermitidos)
            vehiculos.add(auto);
    }

    public void darDeAltaMoto(int velocidad,int aceleracion,int anguloDeGiro,String patente){
        Moto moto = new Moto (velocidad,aceleracion,anguloDeGiro,patente);
        if (vehiculos.size()<=this.cantidadDeVehiculosPermitidos)
            vehiculos.add(moto);
    }

    public void eliminarVehiculo(Vehiculo v){
        vehiculos.remove(v);
    }

    public void eliminarVehiculoConPatente(String patente){
        for(Vehiculo v: this.vehiculos){
            if (v.getPatente().equals(patente))
                vehiculos.remove(v);
            break;
        }
    }

    public Vehiculo determinarGanador(){
        return this.vehiculos.stream()
                .max(Comparator.comparing(v->v.getVelocidad()*0.5*v.getAceleracion()/(v.getAnguloDeGiro()*(v.getPeso()-v.getRuedas()*100))))
                .get();
    }

    public void socorrerAuto(String patente){
        for (Vehiculo v : this.vehiculos)
            if(v.getPatente().equals(patente)){
                this.socorristaAuto.socorrer((Auto)v);
                break;
            }
    }

    public void socorrerMoto(String patente){
        for (Vehiculo v : this.vehiculos)
            if(v.getPatente().equals(patente)){
                this.socorristaMoto.socorrer((Moto)v);
                break;
            }
    }

}
