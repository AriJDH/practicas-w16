package JavaAbstractInterfaceVIVO.ejercicio2;

public class Informe implements Imprimible {
    private String texto;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantidadDePaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String documento() {
        return "Informe : " +
                "\n texto           : " + texto +
                "\n N° de Paginas   : " + cantidadDePaginas +
                "\n autor           : " + autor +
                "\n revisor         : " + revisor;
    }
}
