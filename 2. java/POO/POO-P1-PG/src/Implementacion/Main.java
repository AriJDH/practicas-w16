package Implementacion;

public class Main {
    public static void main(String[] args) {

        Libro libro= new Libro("Harry Potter", "JK Rolling", 20);
        System.out.println(libro.mostrarLibro());
        System.out.println("La cantidad de ejemplares: " + libro.cantidadDeEjemplares());

    }
}
