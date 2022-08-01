package p2pg;

public class Perro extends Animal{

    private String nombre;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Perro(String especie, String nombre) {
        super(especie);
        this.nombre = nombre;
    }

    @Override
    public void mostrarEspecie() {
        super.mostrarEspecie();
        System.out.println("Soy un pedro que ladra");
    }

    @Override
    public void hacerSonido() {
        System.out.println("Guau");
    }
}
