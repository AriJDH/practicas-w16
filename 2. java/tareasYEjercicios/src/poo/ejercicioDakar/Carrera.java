package poo.ejercicioDakar;

import java.util.ArrayList;
import java.util.Comparator;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private ArrayList<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
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

    public ArrayList<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(ArrayList<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
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

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (this.cantidadDeVehiculosPermitidos > 0) {
            this.listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
            this.cantidadDeVehiculosPermitidos--;
            System.out.println("Auto dado de alta");
        } else {
            System.out.println("Ya no hay cupos para la carrera");
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (this.cantidadDeVehiculosPermitidos > 0) {
            this.listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
            this.cantidadDeVehiculosPermitidos--;
            System.out.println("Moto dado de alta");
        } else {
            System.out.println("Ya no hay cupos para la carrera");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        eliminarVehiculoConPatente(vehiculo.getPatente());
    }

    public void eliminarVehiculoConPatente(String patente) {
        Vehiculo vehiculo = buscarVehiculoPorPatente(patente);
        if (vehiculo != null) {
            this.listaDeVehiculos.remove(vehiculo);
            this.cantidadDeVehiculosPermitidos++;
            System.out.println("Auto dado de alta");
        } else {
            System.out.println("El vehiculo con patente " + patente + " no existe");
        }
    }

    public Vehiculo buscarVehiculoPorPatente(String patente) {
        Vehiculo vehiculoEncontrado = this.listaDeVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst().orElse(null);
        return vehiculoEncontrado;
    }

    public Vehiculo definirGanador() {
        Vehiculo vehiculoGanador = this.listaDeVehiculos.stream()
                .max(Comparator.comparing(this::calcularRendmientoVehiculo)).get();
        return vehiculoGanador;
    }

    private Double calcularRendmientoVehiculo(Vehiculo vehiculo) {
        return vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() /
                (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
    }

    public void socorrerAuto(String patente) {
        Vehiculo auto = buscarVehiculoPorPatente(patente);
        if (auto != null) {
            this.socorristaAuto.socorrer((Auto) auto);
        } else {
            System.out.println("El auto con patente " + patente + " no existe");
        }
    }

    public void socorrerMoto(String patente) {
        Vehiculo moto = buscarVehiculoPorPatente(patente);
        if (moto != null) {
            this.socorristaMoto.socorrer((Moto) moto);
        } else {
            System.out.println("La moto con patente " + patente + " no existe");
        }
    }


    @Override
    public String toString() {
        return "\nCarrera " + nombre +
                " distancia: " + distancia +
                ", premioEnDolares: " + premioEnDolares +
                ", cantidadDeVehiculosPermitidos: " + cantidadDeVehiculosPermitidos +
                ", \n" + listaDeVehiculos +
                ", \nsocorristaAuto: " + socorristaAuto +
                ", \nsocorristaMoto: " + socorristaMoto +
                '}';
    }
}
