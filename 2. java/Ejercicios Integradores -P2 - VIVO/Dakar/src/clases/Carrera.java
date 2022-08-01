package clases;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos = new ArrayList<>();
    private SocorristaMoto socorristaMoto;
    private SocorristaAuto socorristaAuto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public void darAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (cantidadVehiculosPermitidos > listaVehiculos.size()) {
            listaVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
            System.out.println("Vehiculo agregado a la carrera");
        } else {
            System.out.println("Ya no hay cupos para la carrera");
        }
    }

    public void darAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (cantidadVehiculosPermitidos > listaVehiculos.size()) {
            listaVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
            System.out.println("Vehiculo agregado a la carrera");
        } else {
            System.out.println("Ya no hay cupos para la carrera");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        listaVehiculos = listaVehiculos.stream()
                .filter(vehiculo -> !patente.equals(vehiculo.getPatente()))
                .collect(Collectors.toList());
    }

    public Vehiculo definirGanador() {
//    List<Double> velocidades = new ArrayList<>();
//    listaVehiculos.forEach(vehiculo -> {
//      velocidades.add((vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2)) /
//          (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedad() * 100)));
//    });
//    Double max = Collections.max(velocidades);
//    int indice = IntStream.range(0,velocidades.size())
//        .filter(i -> max == velocidades.get(i))
//        .findFirst()
//        .orElse(-1);
        Vehiculo maximo = listaVehiculos.stream()
                .max(Comparator.comparing(vehiculo -> (vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2)) / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedad() * 100))))
                .get();

        return maximo;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadVehiculosPermitidos=" + cantidadVehiculosPermitidos +
                ", listaVehiculos=" + listaVehiculos +
                ", socorristaMoto=" + socorristaMoto +
                ", socorristaAuto=" + socorristaAuto +
                '}';
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

    public Integer getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(Integer cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }
}
