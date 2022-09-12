package ejercicio2.Documentos;

import ejercicio2.ClasesAbstractas.Documento;
import ejercicio2.Persona;
import ejercicio2.Interfaces.Imprimir;

import java.util.Arrays;

public class Curriculum extends Documento implements Imprimir {

    private String[] habilidades;

    public Curriculum(Persona persona, String[] habilidades) {
        super(persona);
        this.habilidades = habilidades;
    }

    public String[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String imprimirDocumento() {
        return "**** Curriculum Vitae ****" + "\n"+
                "DNI: " + getPersona().getDni() + "\n"+
                "Nombre: " + getPersona().getNombre()+ "\n"+
                "Edad: " + getPersona().getEdad()+ "\n"+
                "Habilidades: " + Arrays.toString(getHabilidades());
    }
}
