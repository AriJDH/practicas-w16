import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private final SocorristaAutos socorristaAutos;
    private final SocorristaMotos socorristaMotos;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> listaDeVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos + 2;
        this.listaDeVehiculos = listaDeVehiculos;
        this.socorristaAutos = new SocorristaAutos(100, 100, 90, "Toyota", 2000, 6 );
        this.socorristaMotos = new SocorristaMotos(100, 100, 90, "Mercedes", 1200, 4 );
    }

    public void darDeAltaAuto(int velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void darDeAltaMoto(int velocidad, double aceleracion, double anguloDegiro, String patente){
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
            listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDegiro, patente));
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        Vehiculo vehiculoRemover = (Vehiculo) listaDeVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente));
        listaDeVehiculos.remove(vehiculoRemover);
    }

    public void definirGanador(){
        Vehiculo vehiculoGanador = listaDeVehiculos.get(0);
        double maxScore = 0;
        for (Vehiculo vehiculo : listaDeVehiculos){
            double score = vehiculo.getVelocidad()*vehiculo.getAceleracion()/2/(vehiculo.getAnguloDegiro()*(vehiculo.getPeso()-vehiculo.getRuedas()*100));
            if(score>maxScore) vehiculoGanador = vehiculo;
        }
        System.out.println("El ganador de la carrera es: " + vehiculoGanador.toString());
    }

    public void socorrerAuto(String patente){
        Auto vehiculoSocorrer = (Auto) listaDeVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente));
        socorristaAutos.socorrer(vehiculoSocorrer);
    }

    public void socorrerMoto(String patente){
        Moto vehiculoSocorrer = (Moto) listaDeVehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente));
        socorristaMotos.socorrer(vehiculoSocorrer);
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
}
