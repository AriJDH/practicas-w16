package integradores2;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private float distancia;
    private int premio;
    private String nombre;
    private int cantidadPermitido;
    private List<Vehiculo> lista;

    public Carrera() {
    }

    public Carrera(float distancia, int premio, String nombre, int cantidadPermitido) {
        this.distancia = distancia;
        this.premio = premio;
        this.nombre = nombre;
        this.cantidadPermitido = cantidadPermitido;
        this.lista =  new ArrayList<>();
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public int getPremio() {
        return premio;
    }

    public void setPremio(int premio) {
        this.premio = premio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadPermitido() {
        return cantidadPermitido;
    }

    public void setCantidadPermitido(int cantidadPermitido) {
        this.cantidadPermitido = cantidadPermitido;
    }

    public List<Vehiculo> getLista() {
        return lista;
    }

    public void setLista(List<Vehiculo> lista) {
        this.lista = lista;
    }

    public void darDeAltaAuto(float velocidad, float aceleracion, int anguloGiro, String patente){
        if(this.cantidadPermitido >= this.lista.size()){
            Vehiculo nuevoAuto = new Auto(velocidad, aceleracion, anguloGiro, patente);
            lista.add(nuevoAuto);
            System.out.println("Se dio de alta al auto");
        } else {
            System.out.println("No existe cupo en la carrera, se supero el " + this.cantidadPermitido + " permitida");
        }
    }

    public void darDeAltaMoto(float velocidad, float aceleracion, int anguloGiro, String patente){
        if(this.cantidadPermitido >= this.lista.size()){
            Vehiculo nuevaMoto = new Moto(velocidad, aceleracion, anguloGiro, patente);
            lista.add(nuevaMoto);
            System.out.println("Se dio de alta la moto");
        } else {
            System.out.println("No existe cupo en la carrera, se supero el " + this.cantidadPermitido + " permitida");
        }
    }

    public void eliminarVehiculo(Vehiculo e){
        //if (lista.removeIf(vehiculo -> vehiculo.getPatente().equals(e.getPatente()))){
        //if (lista.remove(e){
        lista.remove(e);


/*        System.out.println("Se elimino el vehiculo");
        } else
        {
            System.out.println("No se encontro vehiculo");
        }*/


    }

    public void eliminarVehiculoConPatente(String x){
        lista.removeIf(vehiculo -> vehiculo.getPatente().equals(x));
        System.out.println("Se elimino el vehiculo por patente");
    }

    public void ganador(){
        Vehiculo vehiculoGanador = null;
        float valorMaximo = 0f;
        for(Vehiculo e: lista){
            float valor = (e.getVelocidad()*(e.getAceleracion()*0.5f))/((e.getAnguloGiro())*((e.getPeso()-e.getRuedas())*100));
            if (valor >= valorMaximo){
                valorMaximo = valor;
                vehiculoGanador = e;
            }
        }
        System.out.println("Vehiculo Ganador: " + vehiculoGanador);
    }

    public void socorrerAuto(String patente){
        for(Vehiculo e: lista){
            if (e.getPatente().equals(patente)){
                SocorristaAuto socorrista = new SocorristaAuto();
                socorrista.socorrer(e);
            }
        }
    }

    public void socorrerMoto(String patente){
        for(Vehiculo e: lista){
            if (e.getPatente().equals(patente)){
                SocorristaMoto socorrista = new SocorristaMoto();
                socorrista.socorrer(e);
            }
        }
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premio=" + premio +
                ", nombre='" + nombre + '\'' +
                ", cantidadPermitido=" + cantidadPermitido +
                ", lista=" + lista +
                '}';
    }
}
