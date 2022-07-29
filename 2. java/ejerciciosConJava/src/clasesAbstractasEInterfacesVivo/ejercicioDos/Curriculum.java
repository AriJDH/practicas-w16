package clasesAbstractasEInterfacesVivo.ejercicioDos;

import java.util.List;

public class Curriculum implements Imprimir{
    private String nombre;
    private String apellido;
    private int telefono;
    private String correo;
    private String direccion;
    private List<String> habilidades;

    public Curriculum() {
    }

    public Curriculum(String nombre, String apellido, int telefono, String correo, String direccion,List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.habilidades= habilidades;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void Imprimir() {
        System.out.println("Curriculum vitae: " +'\n'+
                "Nombre: " + nombre + '\n' +
                "Apellido: " + apellido + '\n' +
                "Telefono: " + telefono + '\n' +
                "Correo: " + correo + '\n' +
                "Dirección: " + direccion + '\n' +
                "Tiene estas habilidades: ");

        for(int i=0;i<this.habilidades.size();i++){
            System.out.println(this.habilidades.get(i));
        }

    }
}
