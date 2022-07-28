package EjemploAnimal;

public class Gato extends Animal{
    private String nombre;

    public Gato(String especie, String nombre) {
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
        System.out.println("soy un gato pa");
    }

    @Override
    public void hacerSonido(){
        System.out.println("Miau");
    }

}
