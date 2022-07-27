package ejercicio1;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Lucia", "Perez", 25, "12345");
        Persona persona3 = new Persona("Fabio", "Gomez", 35, "678910", 70.0, 1.71);
        //Persona persona4 = new Persona("Mariana", "50");//el obj persona4 no puede ser instanciado con solo 2 parametros
        //porque no existe tal constructor correspondiente

        System.out.println("\n");
        System.out.println(persona3.toString());

        int imc = persona3.calcularIMC();
        boolean mayorEdad = persona3.esMayorDeEdad();

        if (imc == 0){
            System.out.println("Tiene un peso saludable");
        } else if (imc == -1) {
            System.out.println("Se encuentra bajo de peso");
        } else {
            System.out.println("Se encuentra con sobrepeso");
        }

        if (mayorEdad != false){
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }
    }
}
