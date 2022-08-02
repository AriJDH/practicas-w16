package ejercico2;

import java.util.List;

public class Curriculum {
    private String nombre;
    private String apellido;
    private String email;
    private List<String> habilidades;


    public Curriculum(String nombre, String apellido, String email, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.habilidades = habilidades;
    }

    public Curriculum() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum\n" +
                 nombre  +
                "\n" + apellido +
                "\n" + email +
                "\n" + habilidades;
    }
}
