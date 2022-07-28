package Entity;

import Interface.Imprimible;

public class Informe extends Documento implements Imprimible {
    private String autor;
    private String revisor;
    private int paginas;
    private String texto;

    public Informe(String autor, String revisor, int paginas, String texto) {
        this.autor = autor;
        this.revisor = revisor;
        this.paginas = paginas;
        this.texto = texto;
    }

    @Override
    public void imprimir() {
        System.out.println("Informe{" +
                "autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", paginas=" + paginas +
                ", texto='" + texto + '\'' +
                '}');
    }
}
