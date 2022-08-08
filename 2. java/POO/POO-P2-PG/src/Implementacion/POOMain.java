package Implementacion;

public class POOMain {
    public static void main(String[] args) {

        Animal perro = new Perro("perro", "Lola");
        perro.mostrarEspecie();
        perro.hacerSonidos();

        Gato gato = new Gato("gato", "Luna");
        gato.mostrarEspecie();
        System.out.println(gato.getNombre());
        //gato.hacerSonidos();
        System.out.println("Referenciado");
        Animal animal = perro; //le asigno una referencia existente - objeto que hereda la funcionalidad de la clase
        animal.hacerSonidos();
        animal.mostrarEspecie();
    }
}
