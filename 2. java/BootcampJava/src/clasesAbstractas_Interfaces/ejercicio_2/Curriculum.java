package clasesAbstractas_Interfaces.ejercicio_2;

import java.util.List;

public class Curriculum implements Imprimible{

    private String nombre;
    private String apellido;
    private String dni;
    private String formacionAcademica;

    public Curriculum() {
    }

    public Curriculum(String nombre, String apellido, String dni, String formacionAcademica) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.formacionAcademica = formacionAcademica;

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFormacionAcademica() {
        return formacionAcademica;
    }

    public void setFormacionAcademica(String formacionAcademica) {
        this.formacionAcademica = formacionAcademica;
    }



    @Override
    public String imprimir() {
        return "Curriculum: \n" +
                "   Nombre = " + nombre + "\n" +
                "   Apellido = " + apellido + "\n" +
                "   Dni = " + dni + "\n" +
                "   Formacion Academica = " + formacionAcademica + "\n";
    }

}
