package poo;

public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona();

        Persona persona2 = new Persona("Gabriela", 22, "1099999", 50, 165);

        Persona persona3 = new Persona("Juan", 25, "10000");

        System.out.println("El IMC es: " + persona2.calcularIMC());

        if(persona2.esMayorDeEdad()){
            System.out.println("La persona es mayor de edad");
        }else{
            System.out.println("La persona es menor de edad");
        }

        System.out.println(persona2.toString());

    }
}
