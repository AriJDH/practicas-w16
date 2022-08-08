package asteroid;

public class Participante {
    private String nombre;
    private String apellido;
    private Componente componente;

    public Participante(String nombre, String apellido, Componente componente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.componente = componente;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Componente getComponente() {
        return this.componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public String toString(){
        return (this.nombre + " " + this.apellido);
    }
}
