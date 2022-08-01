package Implementacion;

public class Perro extends Animal {
    //atributos
    private String nombre;

    //getters y setters
    public Perro(String especie, String nombre) {
        super(especie);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    //constructor
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //sobrescribir un metodo del padre

    @Override
    public void mostrarEspecie() {
        super.mostrarEspecie();
        System.out.println("Soy un perro que ladra");
    }

    @Override
    public void hacerSonidos() {
        System.out.println("Guau");
    }
}
