package ejercicio2;

import java.util.List;

public class Curriculum implements Print<Curriculum>{

    private Persona persona;
    private List<String> habilidades;


    @Override
    public String printDocument(Curriculum obj) {
        return null;
    }


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

}
