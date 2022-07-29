package animales;

public abstract class Animal {

    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public abstract void emitirSonido();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
