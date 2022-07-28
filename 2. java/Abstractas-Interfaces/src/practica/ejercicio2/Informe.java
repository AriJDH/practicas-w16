package practica.ejercicio2;

public class Informe implements Imprimible{

    private String texto;
    private int cantidadDePaginas;
    private String autor;

    public Informe(String texto, int cantidadDePaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    private String revisor;

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo informe de"+autor);
        System.out.println("Total de paginas: "+ cantidadDePaginas);
        System.out.println("TEXTO:");
        System.out.println(texto);

    }
}
