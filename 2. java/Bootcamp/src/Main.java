import java.util.HashMap;

public class Main {
    private static final HashMap<Integer, String> REFERENCIAS = new HashMap<Integer, String>();


    public static void main(String[] args) {
        REFERENCIAS.put(-1, "Bajo peso");
        REFERENCIAS.put(0, "Peso saludable");
        REFERENCIAS.put(1, "Sobrepeso");

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Pedro", 25, "40000000");
        Persona persona3 = new Persona("Paula", 25, "41000000", 60.0, 1.64);

        System.out.println(persona3);
        System.out.printf("Indice de masa corporal (IMC): %s\n", REFERENCIAS.get(persona3.calcularIMC()));
        System.out.printf(persona3.esMayorDeEdad() ? "%s es mayor de edad.\n" : "%s es menor de edad.\n", persona3.getNombre());
        System.out.println(persona2);
        System.out.printf(persona2.esMayorDeEdad() ? "%s es mayor de edad.\n" : "%s es menor de edad.\n", persona2.getNombre());

    }
}
