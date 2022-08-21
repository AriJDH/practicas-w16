package JavaAbstractInterfaceVIVO.ejercicio2;

import java.util.List;

public class CurriculumPersona implements Imprimible {

    private String nombre;
    private int dni;
    private List<String> habilidades;

    public CurriculumPersona(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    @Override
    public String documento() {
        return "Curriculum  :    " +
                "\n nombre     :    " + nombre +
                "\n dni        :    " + dni +
                "\n habilidades:    " + habilidades;
    }
}
