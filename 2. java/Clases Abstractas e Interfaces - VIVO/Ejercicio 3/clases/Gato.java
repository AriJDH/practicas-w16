package interfaces3.clases;

import interfaces3.interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    private String nombre;
    private String tipo;
    public Gato(String nombre,String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;

    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void emitirSonido() {
        System.out.println("MIAU!");
    }

    @Override
    public void comerCarne() {
        System.out.println("Come carne");
    }
}
