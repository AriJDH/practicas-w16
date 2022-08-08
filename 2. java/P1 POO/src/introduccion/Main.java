package introduccion;

public class Main {
    public static void main(String[] args){
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Pablo", "183333731", 55);
        Persona persona3 = new Persona("Ricardo", "388865263", 27, 80, 1.90);

        System.out.println(persona3.calcularIMC());

    }
}
