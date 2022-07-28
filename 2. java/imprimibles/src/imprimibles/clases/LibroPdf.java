package imprimibles.clases;

import imprimibles.interfaces.Imprimible;

public class LibroPdf implements Imprimible {
    private int paginas;
    private String autor;
    private String titulo;
    private String genero;

    public LibroPdf(int paginas, String autor, String titulo, String genero) {
        this.paginas = paginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("LibroPdf{" +
                "paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}');
    }
}
