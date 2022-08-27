package Package1;

public class Participante {
    String nombre;
    String apellido;
    double dni;
    int edad;
    double celular;
    double numeroEmergencia;
    String grupoSanguineo;
    int numeroConsecutivo;
    double abono;

    public Participante (){

    }

    public Participante(String nombre, String apellido, double dni, int edad, double celular, double numeroEmergencia, String grupoSanguineo, int numeroConsecutivo, double abono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.numeroConsecutivo = numeroConsecutivo;
        this.abono = abono;
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

    public double getDni() {
        return dni;
    }

    public void setDni(double dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getCelular() {
        return celular;
    }

    public void setCelular(double celular) {
        this.celular = celular;
    }

    public double getNumeroEmergencia() {
        return numeroEmergencia;
    }

    public void setNumeroEmergencia(double numeroEmergencia) {
        this.numeroEmergencia = numeroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getNumeroConsecutivo() {
        return numeroConsecutivo;
    }

    public void setNumeroConsecutivo(int numeroConsecutivo) {
        this.numeroConsecutivo = numeroConsecutivo;
    }

    public double getAbono() {
        return abono;
    }

    public void setAbono(double abono) {
        this.abono = abono;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", edad=" + edad +
                ", celular=" + celular +
                ", numeroEmergencia=" + numeroEmergencia +
                ", grupoSanguineo='" + grupoSanguineo + '\'' +
                ", numeroConsecutivo=" + numeroConsecutivo +
                '}';
    }
}
