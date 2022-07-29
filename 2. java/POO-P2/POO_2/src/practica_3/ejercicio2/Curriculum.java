package practica_3.ejercicio2;

public class Curriculum implements Imprimir {

    private String nombre = "David ";
    private String apellidos = "Lozano";
    private String[] habilidades = {"h1","h2"};

    @Override
    public String toString() {
        return "Nombre : " + nombre + " apellido " + apellidos + "\n"
                + "Habilidades : " + habilidades ;
    }

}
