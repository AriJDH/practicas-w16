package persona;

public class PersonaMain {

    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Ivana", 24, "40865432");
        Persona p3 = new Persona("Juan", 23, "41789650", 80.9, 1.82);
        System.out.println(p3);
        System.out.println("Indice de masa corporal: " + p3.cacularIMC());
        System.out.println("__________________________________________________________________");
        System.out.println("****** REFERENCIAS:                                       ********");
        System.out.println("****** si es menor a 20 = 20               BAJO PESO      ********");
        System.out.println("****** si esta entre 20 y 25 = 0           PESO SALUDABLE ********");
        System.out.println("****** si es mayor a 25 = 1                SOBREPESO      ********");
        System.out.println("__________________________________________________________________");
        System.out.println();
        String mensaje = p3.esMayorDeEdad() ? " es mayor de edad" : " es menor de edad";
        System.out.println(p3.getNombre() + mensaje);
        System.out.println();
        System.out.println("________________________________________________________________");
        System.out.println(" Nombre                        | " + p3.getNombre());
        System.out.println(" Índice de masa corporal (IMC) | " + p3.cacularIMC());
        System.out.println(" Edad                          | " + p3.getEdad());
        System.out.println(" DNI                           | " + p3.getDni());
        System.out.println(" Altura                        | " + p3.getAltura());
        System.out.println(" Peso                          | " + p3.getPeso());
        System.out.println("________________________________________________________________");

    }
}
