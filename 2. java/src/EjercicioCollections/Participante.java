package EjercicioCollections;

public class Participante {

    private String dni;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String celular;
    private String numeroEmergencia;
    private String grupoSanguineo;
    private Integer numeroCorredor;

    public Participante(String dni, String nombre, String apellido, Integer edad, String celular, String numeroEmergencia, String grupoSanguineo,Integer numeroCorredor) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.numeroCorredor = numeroCorredor;
    }

    public Participante() {
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(String numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public Integer getNumeroCorredor() {
        return numeroCorredor;
    }

    public void setNumeroCorredor(Integer numeroCorredor) {
        this.numeroCorredor = numeroCorredor;
    }
}
