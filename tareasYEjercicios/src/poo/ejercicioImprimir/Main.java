package poo.ejercicioImprimir;

public class Main {

    public static void main(String[] args) {


        Informe informe = new Informe("Texto", 32, "Area Finanzas", "Gerente");
        LibroPdf libroPdf = new LibroPdf(12, "Yo", "Algo", "Genero");
        Persona persona = new Persona("Sol", "Barboza", 28);
        
        persona.agregarHabilidad("Idioma Ingles");
        persona.agregarHabilidad("Idioma Frances");
        persona.agregarHabilidad("Idioma Italiano");
        persona.agregarHabilidad("Conocimientos informaticos");
        Curriculum curriculum = new Curriculum(persona);

        Imprimible.imprimirImprimible(informe);
        Imprimible.imprimirImprimible(libroPdf);
        Imprimible.imprimirImprimible(curriculum);

    }
}
