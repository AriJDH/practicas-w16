package imprimibles.clases;

import imprimibles.interfaces.Imprimible;

public class Informe implements Imprimible {

    private String texto;
    private int paginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int paginas, String autor, String revisor) {
        this.texto = texto;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Informe{" +
            "texto='" + texto + '\'' +
                    ", paginas=" + paginas +
                    ", autor='" + autor + '\'' +
                    ", revisor='" + revisor + '\'' +
                    '}');
    }
}
