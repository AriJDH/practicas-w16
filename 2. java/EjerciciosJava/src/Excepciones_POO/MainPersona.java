package Excepciones_POO;

public class MainPersona {

    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Andrés", 17, "12345678");
        Persona persona3 = new Persona("Lucas", 23, "41715987", 63.2, 1.73 );

        if(persona3.calcularIMC() == -1){
            System.out.println("El índice de masa corporal (IMC) de " + persona3.nombre + " está por debajo de 20, por lo cual es de bajo peso.");
        } else if(persona3.calcularIMC() == 0){
            System.out.println("El índice de masa corporal (IMC) de " + persona3.nombre + " está entre 20 y 25 inclusive, por lo cual es de peso saludable.");
        } else {
            System.out.println("El índice de masa corporal (IMC) de " + persona3.nombre + " está por encima de 25, por lo cual se considera sobrepeso.");
        }

        System.out.println("----------------------------------------");

        if(persona3.esMayorDeEdad()){
            System.out.println(persona3.nombre + " es mayor de edad.");
        } else {
            System.out.println(persona3.nombre + " es menor de edad.");
        }

        System.out.println("----------------------------------------");

        System.out.println(persona3);

    }

}
