package Main;

import java.util.List;

public class Curriculum extends Documento {
    private Persona usuario;
    private List<String> habilidades;

    // Constructores

    public Curriculum() {
    }

    public Curriculum(Persona usuario, List<String> habilidades) {
        this.usuario = usuario;
        this.habilidades = habilidades;
    }

    public Curriculum(Persona usuario) {
        this.usuario = usuario;
    }

    // Getters y Setters
    public Persona getUsuario() {
        return usuario;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setUsuario(Persona usuario) {
        this.usuario = usuario;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void mostrarDatos() {
        Imprimible.imprimir();
        System.out.println("Información Personal:\n" +
                this.getUsuario()+".\n" +
                "Habilidades: " + this.getHabilidades());
    }
}
