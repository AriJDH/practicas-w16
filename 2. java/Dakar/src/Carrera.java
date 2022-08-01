import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto unSocorristaDeAutos;
    private SocorristaMoto unSocorristaDeMotos;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos, SocorristaAuto unSocorristaDeAutos, SocorristaMoto unSocorristaDeMotos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.unSocorristaDeAutos = unSocorristaDeAutos;
        this.unSocorristaDeMotos = unSocorristaDeMotos;
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

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public SocorristaAuto getUnSocorristaDeAutos() {
        return unSocorristaDeAutos;
    }

    public void setUnSocorristaDeAutos(SocorristaAuto unSocorristaDeAutos) {
        this.unSocorristaDeAutos = unSocorristaDeAutos;
    }

    public SocorristaMoto getUnSocorristaDeMotos() {
        return unSocorristaDeMotos;
    }

    public void setUnSocorristaDeMotos(SocorristaMoto unSocorristaDeMotos) {
        this.unSocorristaDeMotos = unSocorristaDeMotos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (cantidadDeVehiculosPermitidos > vehiculos.size()){
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(auto);
        }
    }
    public void darDeAltaMoto(double velocidad,double aceleracion,double anguloDeGiro, String patente){
        if (cantidadDeVehiculosPermitidos > vehiculos.size()){
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(moto);
        }
    }
    public void eliminarVehiculo(Vehiculo vehículo){
        for (Vehiculo v: vehiculos){
            if(v == vehículo){
                vehiculos.remove(v);
                break;
            }
        }
  //      vehiculos.stream()
   //             .filter(v ->  v != vehículo);
    }
    public void eliminarVehiculoConPatente(String unaPatente){
        for (Vehiculo v: vehiculos){
            if(v.getPatente() == unaPatente){
                vehiculos.remove(v);
                break;
            }
        }
    }
    public Vehiculo ganardor(){
        double puntajeMaximo = calcularPuntaje(vehiculos.get(0));
        Vehiculo vehiculoGanador = vehiculos.get(0);
        for (Vehiculo v: vehiculos){
            double vPuntaje = calcularPuntaje(v);
            if(vPuntaje > puntajeMaximo){
                puntajeMaximo = vPuntaje;
                vehiculoGanador = v;
            }
        }
        return vehiculoGanador;
    }
    public double calcularPuntaje(Vehiculo vehiculo){
        return vehiculo.getVelocidad() *( 0.5 * vehiculo.getAceleración()) / (vehiculo.getAnguloDeGiro()* vehiculo.getPeso() - vehiculo.getRuedas() * 100);
    }

    public void socorrerAuto(String patente){
        for (Vehiculo v: vehiculos){
            if (v.getPatente() == patente){
                Auto autoASocorrer = new Auto(v.getVelocidad(),v.getAceleración(),v.getAnguloDeGiro(),v.getPatente());
                unSocorristaDeAutos.socorrer(autoASocorrer);
                break;
            }
        }
    }
    public void socorrerMoto(String patente){
        for (Vehiculo v: vehiculos){
            if (v.getPatente() == patente){
                Moto motoASocorrer = new Moto(v.getVelocidad(),v.getAceleración(),v.getAnguloDeGiro(),v.getPatente());
                unSocorristaDeMotos.socorrer(motoASocorrer);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", vehiculos=" + vehiculos +
                ", unSocorristaDeAutos=" + unSocorristaDeAutos +
                ", unSocorristaDeMotos=" + unSocorristaDeMotos +
                '}';
    }
}
