package EjemploAnimal;

public class POOMain {
    public static void main(String[] args) {
        Animal perro = new Perro("Perro", "Firulais");
        perro.hacerSonido();
        perro.mostrarEspecie();

        Gato gato = new Gato("Gato", "Miau");
        gato.hacerSonido();
        gato.mostrarEspecie();
        gato.setNombre("richard");
        System.out.println(gato.getNombre());

        Animal animal = perro;
        animal.hacerSonido();
        animal.mostrarEspecie();
    }
}
