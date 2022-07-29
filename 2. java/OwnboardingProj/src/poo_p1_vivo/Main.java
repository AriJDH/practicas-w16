package poo_p1_vivo;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Jorge",21, "1a2jf8jf");
        Persona p3 = new Persona("Mario", 30, "k19f9ffff", 50f, 180.5f);

        System.out.println(p3.toString());
    }
}
