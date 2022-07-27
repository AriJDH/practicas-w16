package estructuraDinamica;

public class Competidor {
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int nroEmergencia;
    private String sanguineo;

    public Competidor() {
    }

    public Competidor(int dni, String nombre, String apellido, int edad, int celular, int nroEmergencia, String sanguineo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.nroEmergencia = nroEmergencia;
        this.sanguineo = sanguineo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getNroEmergencia() {
        return nroEmergencia;
    }

    public void setNroEmergencia(int nroEmergencia) {
        this.nroEmergencia = nroEmergencia;
    }

    public String getSanguineo() {
        return sanguineo;
    }

    public void setSanguineo(String sanguineo) {
        this.sanguineo = sanguineo;
    }

    @Override
    public String toString() {
        return "Competidor{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", celular=" + celular +
                ", nroEmergencia=" + nroEmergencia +
                ", sanguineo='" + sanguineo + '\'' +
                '}';
    }
}
