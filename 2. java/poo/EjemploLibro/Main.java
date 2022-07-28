package EjemploLibro;

public class Main {
    public static void main(String[] args)
    {
        Libro libro = new Libro("prueba","ruben",10);

        System.out.println(libro.mostrarLibro());
        System.out.println("cantidad de ejemplares "+libro.cantidadEjemplares());
        Libro.saludar();
    }
}
