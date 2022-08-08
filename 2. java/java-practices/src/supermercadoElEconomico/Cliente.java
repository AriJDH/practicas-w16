package supermercadoElEconomico;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;

    public Cliente(){
        this.dni = "";
        this.nombre = "";
        this.apellido = "";
    }

    public Cliente(String dni, String nombre, String apellido){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String toString(){
        return ("DNI: " + this.dni + " | " + this.nombre + " " + this.apellido + ".");
    }
}
