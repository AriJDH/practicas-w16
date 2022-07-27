package clases;

public class Main {

    public static void main(String[] args) {
        Libro libro = new Libro("Harry Potter", "J. K. Rowling", 10);
        System.out.println(libro.mostrarLibro());
        System.out.println("La cantidad de ejemplares para este Libro es de: " + libro.cantidadDeEjemplares());
    }

}
