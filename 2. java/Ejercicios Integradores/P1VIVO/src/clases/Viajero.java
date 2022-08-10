package clases;

import java.util.ArrayList;
import java.util.List;

public class Viajero {
    private String nombre;
    private String dni;

    private List<Localizador> listaLocalizador = new ArrayList<>();

    public Viajero(String nombre, String dni, List<Localizador> listaLocalizador) {
        this.nombre = nombre;
        this.dni = dni;
        this.listaLocalizador = listaLocalizador;
    }

    @Override
    public String toString() {
        return "Viajero{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public List<Localizador> getListaLocalizador() {
        return listaLocalizador;
    }

    public void setListaLocalizador(List<Localizador> listaLocalizador) {
        this.listaLocalizador = listaLocalizador;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Viajero(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }
}
