package Entity;

import Interface.Imprimible;

public class Libro extends Documento implements Imprimible {
    private String autor;
    private String Titulo;
    private String genero;
    private int paginas;

    public Libro(String autor, String titulo, String genero, int paginas) {
        this.autor = autor;
        Titulo = titulo;
        this.genero = genero;
        this.paginas = paginas;
    }

    @Override
    public void imprimir() {
        System.out.println("Libro{" +
                "autor='" + autor + '\'' +
                ", Titulo='" + Titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", paginas=" + paginas +
                '}');
    }
}
