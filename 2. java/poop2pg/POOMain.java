package p2pg;

public class POOMain {

    public static void main(String[] args) {

        Animal perro = new Perro("Perro", "Tito");
        perro.mostrarEspecie();
        perro.hacerSonido();

        Gato gato = new Gato("Gato", "Poker");
        gato.mostrarEspecie();
        gato.hacerSonido();

        Animal animal = perro;
        animal.mostrarEspecie();
        animal.hacerSonido();
    }
}
