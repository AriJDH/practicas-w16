package main;

public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("John Doe", 20, "1234567890");
        Persona persona3 = new Persona("John Doe", 20, "1234567890", 80, 1.80);

        int imc = persona3.calcularIMC();
        boolean mayorDeEdad = persona3.esMayorDeEdad();

        if(imc == -1)
            System.out.println("La Persona tiene un peso bajo");
        else if(imc == 0)
            System.out.println("La Persona tiene un peso saludable");
        else
            System.out.println("La Persona tiene un peso alto");

        System.out.println("La persona " + (mayorDeEdad ? "" : "no ") + "es mayor de edad");

        System.out.println(persona3.toString());
    }
}
