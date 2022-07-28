package interfaces.models;

public class Cobradores {
    private String nombre;
    private int edad;
    private String dni;
    private String empresa;

    public Cobradores() {
    }

    public Cobradores(String nombre, int edad, String dni, String empresa) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
