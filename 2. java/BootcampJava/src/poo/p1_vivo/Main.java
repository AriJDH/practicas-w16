package poo.p1_vivo;

public class Main {

    public static void main(String[] args){

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan Pablo","12345678", 29 );
        Persona persona3 = new Persona("Agustin", "87654321", 26, 72.5f, 1.75f);
        Persona persona4 = new Persona("Marcela",null,25);

        Persona.toString(persona3);
        try {

        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        } finally {
            ;
        }
    }
}
