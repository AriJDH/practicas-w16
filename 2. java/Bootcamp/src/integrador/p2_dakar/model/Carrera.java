package integrador.p2_dakar.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculos = cantidadDeVehiculos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        if(this.cantidadDeVehiculos <= this.vehiculos.size()) return;
        this.vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        if(this.cantidadDeVehiculos <= this.vehiculos.size()) return;
        this.vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        this.vehiculos.remove(vehículo);
    };

    public void eliminarVehiculoConPatente(String patente){
        this.vehiculos.remove(this.getVehiculoPorPatente(patente));
    };

    public Vehiculo getGanador(){
        return this.vehiculos.stream()
                .max(Comparator.comparing(v->v.getVelocidad()*0.5*v.getAceleracion()/(v.getAnguloDeGiro()*(v.getPeso()-v.getRuedas()*100))))
                .get();
    }

    public Vehiculo getVehiculoPorPatente(String patente) {
        return this.vehiculos.stream()
                .filter(v->v.getPatente().equalsIgnoreCase(patente))
                .findFirst()
                .get();
    }

    public void socorrerAuto(String patente){
        Vehiculo vehiculo = this.getVehiculoPorPatente(patente);
        if (vehiculo.equals(null) || !(vehiculo instanceof Auto)) return;
        this.socorristaAuto.socorrer((Auto) vehiculo);
    }

    public void socorrerMoto(String patente){
        Vehiculo vehiculo = this.getVehiculoPorPatente(patente);
        if (vehiculo.equals(null) || !(vehiculo instanceof Moto)) return;
        this.socorristaMoto.socorrer((Moto) vehiculo);
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}
