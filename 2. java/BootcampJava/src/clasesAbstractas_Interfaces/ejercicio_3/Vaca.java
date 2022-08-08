package clasesAbstractas_Interfaces.ejercicio_3;

public class Vaca extends Animal implements Herviboro{

    private String nombre;
    private int edad;

    public Vaca() {
    }

    public Vaca(String nombre, int edad) {
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
        System.out.println("Muu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Quiero comer pasto");
    }
}
