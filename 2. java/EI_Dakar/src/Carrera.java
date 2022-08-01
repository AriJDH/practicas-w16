import java.util.HashSet;
import java.util.Set;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private Set<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;

    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new HashSet<>();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (!hayCupoDisponible()) {
            System.out.println("No hay cupo disponible para dar de alta un auto ");
            return;
        }

        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        if (listaDeVehiculos.contains(auto)) {
            System.out.println("El Auto ya estaba inscripto");
            return;
        }

        listaDeVehiculos.add(auto);
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (!hayCupoDisponible()) {
            System.out.println("No hay cupo disponible para dar de alta un auto ");
            return;
        }

        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        if (listaDeVehiculos.contains(moto)) {
            System.out.println("El Auto ya estaba inscripto");
            return;
        }

        listaDeVehiculos.add(moto);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        try {
            listaDeVehiculos.remove(vehiculo);
        }
        catch (Exception e) {
            System.out.println("No se pudo eliminar el vehiculo");
        }
    }

    public void eliminarVehiculoConPatente(String patente) {
        try {
            for (Vehiculo vehiculo : listaDeVehiculos) {
                if (vehiculo.getPatente().equals(patente)) {
                    listaDeVehiculos.remove(vehiculo);
                    return;
                }
            }
        }
        catch (Exception e) {
            System.out.println("No se pudo eliminar el vehiculo");
        }
    }

    private boolean hayCupoDisponible() {
        return listaDeVehiculos.size() < cantidadDeVehiculosPermitidos;
    }

    public void ganador()
    {
        Double max = 0.0;
        Vehiculo ganador = null;

        for (Vehiculo vehiculo : listaDeVehiculos) {
            Double valor = vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2) / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if (valor > max) {
                max = valor;
                ganador = vehiculo;
            }
        }

        System.out.println("El ganador es: " + ganador);
    }

    public void socorrerAuto(String patente)
    {
        Auto auto = new Auto();

        try {
            for (Vehiculo vehiculo : listaDeVehiculos) {
                if (vehiculo.getPatente().equals(patente) && vehiculo instanceof Auto){
                    auto.setAceleracion(vehiculo.getAceleracion());
                    auto.setAnguloDeGiro(vehiculo.getAnguloDeGiro());
                    auto.setVelocidad(vehiculo.getVelocidad());
                    auto.setPatente(vehiculo.getPatente());
                    auto.setRuedas(vehiculo.getRuedas());
                    auto.setPeso(vehiculo.getPeso());
                }
            }

            if(auto != null){
                socorristaAuto.socorrer(auto);
            } else {
                System.out.println("No existe auto con la patente especificada para ser socorrido.");
            }
        }
        catch (Exception e) {
            System.out.println("No se pudo socorrer el auto: " +e);
        }

    }

    public void socorrerMoto(String patente)
    {
        Moto moto = null;

        try {
            for (Vehiculo vehiculo : listaDeVehiculos) {
                if (vehiculo.getPatente().equals(patente) && vehiculo instanceof Moto){
                    moto = (Moto)vehiculo;
                }
            }

            if(moto != null){
                socorristaMoto.socorrer(moto);
            } else {
                System.out.println("No existe moto con la patente especificada para ser socorrido.");
            }
        }
        catch (Exception e) {
            System.out.println("No se pudo socorrer la moto");
        }
    }

    public void save(Vehiculo vehiculo){
        listaDeVehiculos.add(vehiculo);
    }
}
