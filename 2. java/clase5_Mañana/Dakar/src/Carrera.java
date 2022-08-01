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

    public void determinarGanador(){
        Vehiculo ganador = null;
        double velGanador = 0.0;
        double velVehiculo;
        for (Vehiculo v : this.vehiculos){
            velVehiculo = ((v.getVelocidad()/2)*v.getAceleracion())/
                    (v.getAnguloDeGiro()*(v.getPeso()-v.getRuedas()*100));
            if (velVehiculo>velGanador){
                velGanador=velVehiculo;
                ganador=v;
            }
        }
        System.out.println("El ganador de la carrera es: "+ ganador.toString());
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
