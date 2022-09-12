package ejercicio2.ClasesAbstractas;

import ejercicio2.Persona;

public abstract class Documento {

    private Persona persona;
    private int cantidadDePaginas;

    public Documento(){

    }

    public Documento(Persona persona, int cantidadDePaginas) {
        this.persona = persona;
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public Documento(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }
}
