package Turismo.Entidad;

public class Cliente {

    private int id;
    private String dni;
    private String nombre;

    public Cliente(int id, String dni, String nombre) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
    }
    public Cliente(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int cantidadDeReservas(){
        return  0;
    }
}
