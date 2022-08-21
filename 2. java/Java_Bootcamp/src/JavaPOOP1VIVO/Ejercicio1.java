package JavaPOOP1VIVO;

public class Ejercicio1 {

    public static void main(String[] args) {
        Persona persona = new Persona("Daniel", 26, "123456789", 89, 1.78);

        System.out.println("Analisis de Persona IMC: ");

        switch (persona.calcularIMC()) {
            case -1:
                System.out.printf("Presenta: " + "Bajo peso");
                break;
            case 0:
                System.out.printf("Presenta: " + "Peso saludable");
                break;
            case 1:
                System.out.printf("Presenta: " + "Sobrepeso");
                break;
        }
        System.out.println("");
        if (persona.esMayordeEdad()) {
            System.out.println("Es Mayor de edad !!");
        } else {
            System.out.println("Es Menor de edad !!");
        }

        System.out.printf(persona.toString());
    }
}
