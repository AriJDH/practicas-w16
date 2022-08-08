package documentos;

import java.util.List;

public class Curriculum extends Documento implements Imprimible {
    private Persona persona;
    private List<String> listaDeHabilidades;

    public Curriculum(){

    }

    public Curriculum(Persona persona, List<String> listaDeHabilidades){
        this.persona = persona;
        this.listaDeHabilidades = listaDeHabilidades;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<String> getListaDeHabilidades() {
        return this.listaDeHabilidades;
    }

    public void setListaDeHabilidades(List<String> listaDeHabilidades) {
        this.listaDeHabilidades = listaDeHabilidades;
    }

    @Override
    public void imprimirContenido() {
        System.out.println("Curriculum impreso.");
    }
}
