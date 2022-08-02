package CarreraDeLaSelva;

public class Participante {

    private String nombre;
    private String dni;
    private String apellido;
    private Integer edad;
    private String numeroEmergencia;
    private String celular;
    private String grupoSanguineo;

    public Participante(String nombre, String dni, String apellido, Integer edad, String numeroEmergencia, String celular, String grupoSanguineo) {
        this.nombre = nombre;
        this.dni = dni;
        this.apellido = apellido;
        this.edad = edad;
        this.numeroEmergencia = numeroEmergencia;
        this.celular = celular;
        this.grupoSanguineo = grupoSanguineo;
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

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(String numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", numeroEmergencia='" + numeroEmergencia + '\'' +
                ", celular='" + celular + '\'' +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                '}';
    }
}
