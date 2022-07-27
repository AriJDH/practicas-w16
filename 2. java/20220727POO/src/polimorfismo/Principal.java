package polimorfismo;

public class Principal {
    public static void main(String[] args) {
        Animal a = new Animal();
        Perro b = new Perro();
        Animal c = new Gato();

        a.hacerSonido();
        b.hacerSonido();
        c.hacerSonido();

    }
}
