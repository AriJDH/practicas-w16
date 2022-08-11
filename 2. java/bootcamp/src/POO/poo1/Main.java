package POO.poo1;

public class Main {

    public static void main(String[] args) {
        Persona persona1 = new Persona();

        char[] dni = new char[5];
        dni[0] = '1';
        dni[1] = '2';
        dni[2] = '3';
        dni[3] = '4';
        dni[4] = '5';

        Persona persona2 = new Persona("Persona2", 23, dni);

        char[] dni_2 = new char[5];
        dni_2[0] = '6';
        dni_2[1] = '7';
        dni_2[2] = '8';
        dni_2[3] = '9';
        dni_2[4] = '0';
        Persona persona3 = new Persona("Persona3", 28, dni_2, 63, 1.58);


        int imc = persona2.calcularIMC();
        if (imc == -1)
            System.out.println("La persona tiene bajo peso");
        else if (imc == 0)
            System.out.println("La persona tiene peso saludable");
        else
            System.out.println("La persona tiene sobrepeso");

        if (persona3.esMayorDeEdad())
            System.out.println("La persona es mayor de edad");
        else
            System.out.println("La persona es menor de edad");

        System.out.println("Datos de la persona:\n" + persona3.toString());
    }
}
