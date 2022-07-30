package Ejercicios2;

public class Informes implements imprimible {
    private int texto;
    private int numeroPaginas;
    private String autor;
    private String revisor;

    public Informes(int texto, int numeroPaginas, String autor, String revisor) {
        this.texto = texto;
        this.numeroPaginas = numeroPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    private String nTexto(int n){
        String texto = "";
        for (int i = 0; i < n; i++) {
            texto += "*";
        }
        return texto;
    }

    @Override
    public void imprimir() {
        System.out.println("Texto random: " + nTexto(this.texto));
        System.out.println("Numero de paginas: " + numeroPaginas);
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
    }
}


