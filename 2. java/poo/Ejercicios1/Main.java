package Ejercicios1;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 30, "12345678A");
        Persona persona3 = new Persona("Juan", 30, "12345678A", 75, 1.75);
        //Persona persona4 = new Persona("ruben", 20);  no puede resolver esto, da error

        if (persona3.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("No es mayor de edad");
        }

        if (persona3.calcularIMC() == -1){
            System.out.println("Usted tiene un peso bajo");
        } else if (persona3.calcularIMC() == 0){
            System.out.println("Usted tiene Peso saludable");
        } else {
            System.out.println("Usted tiene sobrepeso");
        }

        System.out.println(persona3.toString());

    }
}
