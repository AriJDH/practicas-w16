package p1pg;

public class Main {
    public static void main(String[] args) {

        /*Libro libro = new Libro("Harry Poter", "J.K.Rolling", 20);
        System.out.println(libro.mostrarLibro());
        System.out.println("La cantidad de ejemplares es: " + libro.cantidadDeEjemplares());*/

        Persona persona1  = new Persona();
        Persona persona2  = new Persona("Camilo", 30, "12.345.678");
        Persona persona3  = new Persona("Juan", 35, "11.111.111", 70.2, 1.75);
        System.out.println("La persona es mayor de edad: " + persona3.esMayorDeEdad());
        System.out.println("Su IMC es: " + persona3.calcularIMC());
        System.out.println(persona3.toString());

    }
}
