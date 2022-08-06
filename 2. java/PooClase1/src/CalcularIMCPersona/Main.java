package CalcularIMCPersona;

public class Main {
    public static void main(String[] args) {

        Persona personaSinParametros = new Persona();
        Persona personaCon3Parametros = new Persona("Juliana","27","123456789");
        Persona persona = new Persona("Juliana Andrea","27","1234",50.3,1.62);

        // Persona personaNombre = new Persona("Juli");
        // Persona perosnaEdad = new Persona("27 años");

        System.out.println("\nCalculo del IMC (Indice de Masa Corporal)");
        if(persona.calcularIMC()==-1) System.out.println("Se encuentra con bajo peso, ya que su IMC es menor que 20");
        else if(persona.calcularIMC()==0) System.out.println("Se encuentra con un peso saludable, ya que su IMC se encuentra entre 20 y 25");
        else System.out.println("Se encuentra con sobrepeso, ya que su IMC es mayor a 25");

        System.out.println("\n********************************");
        System.out.println("Valdación de su mayoria de edad");
        if(persona.esMayorDeEdad()) System.out.println("La persona "+persona.nombre+" es mayor de edad, con"+persona.edad+" años");
        else System.out.println("La persona "+persona.nombre+" es menor de edad, con"+persona.edad+" años");

        System.out.println("\n********************************");
        System.out.println("Datos de la persona");
        System.out.println(persona.toString());

    }
}
