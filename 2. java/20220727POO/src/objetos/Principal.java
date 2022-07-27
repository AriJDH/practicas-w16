package objetos;

public class Principal {

    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Daniel",31,"35778008");
        Persona p3 = new Persona("Daniel",31,"35778008", 84.2,1.82);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());



    }
}
