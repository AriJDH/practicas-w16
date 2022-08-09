package ejercicio2;

public class Main {
    public static void main(String[] args) {

        Curriculum curriculum = new Curriculum("Camilo", "Palma", 30, "Javascript", "Logica");
        Imprimir.imprimir(curriculum);

        Libro libro = new Libro(200, "J.K. Rowling", "Harry Postre", "Ficcion");
        Imprimir.imprimir(libro);

    }
}
