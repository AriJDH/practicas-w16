package Imprimir;

import java.util.Date;
import java.util.List;

public class Curriculum implements IImprimir {
    private String Nombre;
    private String Apellido;
    private Date FechaNacimiento;
    private String DNI;
    private List<String> LstHabilidades;

    public Curriculum(String nombre, String apellido, Date fechaNacimiento, String DNI, List<String> lstHabilidades) {
        Nombre = nombre;
        Apellido = apellido;
        FechaNacimiento = fechaNacimiento;
        this.DNI = DNI;
        LstHabilidades = lstHabilidades;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public List<String> getLstHabilidades() {
        return LstHabilidades;
    }

    public void setLstHabilidades(List<String> lstHabilidades) {
        LstHabilidades = lstHabilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimir Curriculum");
    }
}
