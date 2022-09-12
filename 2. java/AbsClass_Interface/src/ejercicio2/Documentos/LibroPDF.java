package ejercicio2.Documentos;

import ejercicio2.ClasesAbstractas.Documento;
import ejercicio2.Interfaces.Imprimir;
import ejercicio2.Persona;

public class LibroPDF extends Documento implements Imprimir {

    private String titulo;
    private String genero;

    public LibroPDF(Persona persona, int cantidadDePaginas, String titulo, String genero) {
        super(persona, cantidadDePaginas);
        this.titulo = titulo;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String imprimirDocumento() {
        return "**** Libro en PDF ****" + "\n"+
                "Autor: " + getPersona().getNombre() + "\n"+
                "Cantidad de Páginas: " + getCantidadDePaginas() + "\n"+
                "Título: " + getTitulo() + "\n"+
                "Género: " + getGenero();

    }
}
