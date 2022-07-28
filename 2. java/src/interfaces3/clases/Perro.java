package interfaces3.clases;

import interfaces3.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    private String nombre;
    private String tipo;

    public Perro(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Perro() {
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void emitirSonido() {
        System.out.println("GUAU!");
    }

    @Override
    public void comerCarne() {
        System.out.println("Come carne");
    }
}
