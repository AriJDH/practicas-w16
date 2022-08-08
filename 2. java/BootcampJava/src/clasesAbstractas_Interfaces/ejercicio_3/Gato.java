package clasesAbstractas_Interfaces.ejercicio_3;

public class Gato extends Animal implements Carnivoro{

    private String nombre;
    private int edad;

    public Gato() {
    }

    public Gato(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Quiero comer pescado");
    }
}
