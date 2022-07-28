package EjemploAnimal;

public class Perro extends Animal{
    private String nombre;

    public Perro(String especie, String nombre) {
        super(especie);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void mostrarEspecie(){
        super.mostrarEspecie();
        System.out.println("soy un perro");
    }

    @Override
    public void hacerSonido(){
        System.out.println("Guau");
    }
}
