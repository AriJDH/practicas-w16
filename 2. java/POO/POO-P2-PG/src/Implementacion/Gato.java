package Implementacion;

public class Gato extends Animal{
    //atributos
    private String nombre;

    //getters y setters
    public Gato(String especie, String nombre) {
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
        System.out.println("Soy un gato que maulla");
    }

    /*@Override
    public void hacerSonidos() {
        System.out.println("Miau");
    }*/
}
