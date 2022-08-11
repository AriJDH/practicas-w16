package poo_p1_vivo;

import java.util.HashMap;

public class Main {
    private static final HashMap<Integer, String> REFERENCIAS = new HashMap<Integer, String>();

    private static final void mostrarDatosPersona(Persona persona){
        System.out.println(persona);
        if(persona.getPeso() > 0) System.out.printf("Indice de masa corporal (IMC): %s\n", REFERENCIAS.get(persona.calcularIMC()));
        if(persona.getEdad() > 0) System.out.printf(persona.esMayorDeEdad() ? "%s es mayor de edad.\n" : "%s es menor de edad.\n", persona.getNombre());
        System.out.println();
    }

    public static void main(String[] args) {
        REFERENCIAS.put(-1, "Bajo peso");
        REFERENCIAS.put(0, "Peso saludable");
        REFERENCIAS.put(1, "Sobrepeso");

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Pedro", 25, "40000000");
        Persona persona3 = new Persona("Paula", 25, "41000000", 60.0, 1.64);

        mostrarDatosPersona(persona3);
        mostrarDatosPersona(persona2);
    }
}
