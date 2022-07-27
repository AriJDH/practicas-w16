package EjercicioClases;

public class Animal {
    public void hacerSonido(){
        System.out.println("el animial esta haciendo sondio");
    }

    public static void main(String[] args) {
        Animal animal =new Animal();
        Animal animal1 = new Gato();
        Perro animal2=new Perro();
        animal.hacerSonido();
        animal1.hacerSonido();
        animal2.hacerSonido();



    }
}
