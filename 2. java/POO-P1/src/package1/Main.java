package package1;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Marcela", 25, "1043023298");
        Persona persona3 = new Persona("Paula", 18, "1043765890", 20, 1.65);

        Persona persona4 = new Persona("Juan", 28, "");

        System.out.println(persona3.calcularIMC());
        System.out.println(persona3.esMayorDeEdad());
        System.out.println(persona3.toString());
    }
}
