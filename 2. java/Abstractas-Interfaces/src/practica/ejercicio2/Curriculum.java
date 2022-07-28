package practica.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Imprimible{
    private Persona datos;
    private List<String> habilidades = new ArrayList<>();


    public Curriculum(Persona datos) {
        this.datos = datos;
    }
    public void agregarHabilidad(String habilidad){
        habilidades.add(habilidad);
    }

    @Override
    public void imprimir() {
        System.out.println("Mostrando el curriculum de " + datos.getNombre() + " " + datos.getApellido());
        System.out.println("Edad: "+datos.getEdad());
        System.out.println("Habilidades: ");
        habilidades.forEach(hab -> System.out.println("- "+hab));
    }
}
