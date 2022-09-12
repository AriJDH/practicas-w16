package ejercicio2.Documentos;

import ejercicio2.ClasesAbstractas.Documento;
import ejercicio2.Interfaces.Imprimir;
import ejercicio2.Persona;

public class Informe extends Documento implements Imprimir {

    private Persona persona2;
    private int longitudTexto;

    public Informe(Persona persona, int cantidadDePaginas, Persona persona2, int longitudTexto) {
        super(persona, cantidadDePaginas);
        this.persona2 = persona2;
        this.longitudTexto = longitudTexto;
    }

    public Persona getPersona2() {
        return persona2;
    }

    public void setPersona2(Persona persona2) {
        this.persona2 = persona2;
    }

    public int getLongitudTexto() {
        return longitudTexto;
    }

    public void setLongitudTexto(int longitudTexto) {
        this.longitudTexto = longitudTexto;
    }

    @Override
    public String imprimirDocumento() {
        return "**** Informe ****" + "\n"+
                "Autor: " + getPersona().getNombre() + "\n"+
                "Longitud del texto: " + getLongitudTexto() + "\n"+
                "Cantidad de Páginas: " + getCantidadDePaginas() + "\n"+
                "Revisor: " + getPersona2().getNombre();
    }
}
