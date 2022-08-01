package p2pg;

public class Gato extends Animal {

    private String nombre;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Gato(String especie, String nombre) {
        super(especie);
        this.nombre = nombre;
    }

    @Override
    public void mostrarEspecie() {
        super.mostrarEspecie();
        System.out.println("Soy un gato que maulla");
    }

    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }
}
