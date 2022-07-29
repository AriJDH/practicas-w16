package practica_3.ejercicio2;

public class LibroPdF {
    private int cantidadPaginas = 1;
    private String nombre = "Nombre libro";
    private String nombreAutor = "Titulo libro";
    private String genero = "genero libro";

    @Override
    public String toString() {
        return "Nombre libro: " + nombre + " autor " + nombreAutor + "\n"
                + "genero : " + genero + " cantidad de paginas : " + cantidadPaginas ;
    }
}
