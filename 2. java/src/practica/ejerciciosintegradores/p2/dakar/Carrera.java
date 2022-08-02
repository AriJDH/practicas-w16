package practica.ejerciciosintegradores.p2.dakar;

import java.util.List;

public class Carrera {

    protected double distancia;
    protected int premioEnDolares;
    protected String nombre;
    protected int cantidadDeVehiculosPermitidos;
    protected List<Vehiculo> vehiculos;

    protected SocorristaAuto socorristaAuto;
    protected SocorristaMoto socorristaMoto;

    public void darDeAltaAuto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        if (this.getVehiculos().size() < this.getCantidadDeVehiculosPermitidos()) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            this.getVehiculos().add(auto);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        if (this.getVehiculos().size() < this.getCantidadDeVehiculosPermitidos()) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            this.getVehiculos().add(moto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.getVehiculos().remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        this.getVehiculos().remove(
                this.getVehiculos().stream()
                        .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                        .findFirst()
                        .orElse(null)
        );
    }

    public Vehiculo obtenerGanador() {
        double valorGanador = 0;
        Vehiculo ganador = this.getVehiculos().get(0);
        for (Vehiculo vehiculo : this.getVehiculos()) {
            double valorVehiculo = vehiculo.getVelocidad() * ((vehiculo.getAceleracion() / 2) / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100)));
            if (valorVehiculo > valorGanador) {
                valorGanador = valorVehiculo;
                ganador = vehiculo;
            }
        }

        return ganador;
    }

    public void socorrerAuto(String patente) {
        SocorristaAuto socorristaAuto = new SocorristaAuto(100, 80, 90, "SOC-AUTO-1");
        Auto autoSocorro = (Auto) this.getVehiculos().stream()
                .filter(vehiculo -> vehiculo instanceof Auto && vehiculo.getPatente().equals(patente))
                .findFirst()
                .orElse(new Auto());
        socorristaAuto.socorrer(autoSocorro);
    }

    public void socorrerMoto(String patente) {
        SocorristaMoto socorristaMoto = new SocorristaMoto(130, 120, 180, "SOC-MOTO-1");
        Moto motoSocorro = (Moto) this.getVehiculos().stream()
                .filter(vehiculo -> vehiculo instanceof Moto && vehiculo.getPatente().equals(patente))
                .findFirst()
                .orElse(new Moto());
        socorristaMoto.socorrer(motoSocorro);
    }

    public Carrera(double distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(int premioEnDolares) {
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
}
