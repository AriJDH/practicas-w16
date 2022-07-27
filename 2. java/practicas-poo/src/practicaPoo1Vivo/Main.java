package practicaPoo1Vivo;

import java.util.HashMap;

public class Main {

    private static final HashMap<Integer, String> DESCRIPCIONES_MASA_CORPORAL = new HashMap<>() {{
        put(-1, "Bajo Peso");
        put(0, "Peso Saludable");
        put(1, "Sobrepeso");
    }};

    public static void main(String[] args) {
        Persona personaSinIdentificacion = new Persona();
        Persona personaSinDatosFisicos = new Persona("Nicolas", "42312772", 22);
        Persona personaConTodosLosDatos = new Persona("Nicolas", "42312772", 22, 70, 1.75d);

        // No puedo crearlo solo con un parametro (como por ejemplo el nombre) ya que no tiene
        // un constructor que admita esta posibilidad.

        System.out.println(personaConTodosLosDatos.toString());
        System.out.println("Persona es mayor de edad: " + personaConTodosLosDatos.esMayorDeEdad());
        System.out.println(DESCRIPCIONES_MASA_CORPORAL.get(personaConTodosLosDatos.calcularIMC()));
    }

}
