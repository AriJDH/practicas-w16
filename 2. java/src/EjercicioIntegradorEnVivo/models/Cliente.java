package EjercicioIntegradorEnVivo.models;

import java.util.List;

public class Cliente {

    private String dni;
    private String nombre;
    private String apellido;
    private String numeroTelefonico;
    private List<Localizadores> localizadoresList;

    public Cliente() {
    }

    public Cliente(String dni, String nombre, String apellido, String numeroTelefonico, List<Localizadores> localizadoresList) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTelefonico = numeroTelefonico;
        this.localizadoresList = localizadoresList;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", numeroTelefonico='" + numeroTelefonico + '\'' +
                ", localizadoresList=" + localizadoresList +
                '}';
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public List<Localizadores> getLocalizadoresList() {
        return localizadoresList;
    }

    public void setLocalizadoresList(List<Localizadores> localizadoresList) {
        this.localizadoresList = localizadoresList;
    }

    public void addLocalizador(Localizadores localizadores){
        this.localizadoresList.add(localizadores);
    }
}
