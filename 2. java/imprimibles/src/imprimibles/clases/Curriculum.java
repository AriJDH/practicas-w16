package imprimibles.clases;

import imprimibles.interfaces.Imprimible;

import java.util.List;

public class Curriculum implements Imprimible {

    private Persona persona;
    private List<String> habilidades;

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum{" +
                "persona=" + persona +
                ", habilidades=" + habilidades +
                '}');
    }
}
