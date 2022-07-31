public class Clientes {

    private String dni;
    private String nombre;
    private String apellido;
    private int celular;

    public  Clientes(String dni, String nombre, String apellido, int celular){
        this.dni=dni;
        this.nombre=nombre;
        this.apellido=apellido;
        this.celular=celular;

    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getCelular() {
        return celular;
    }

    public String getApellido() {
        return apellido;
    }
}
