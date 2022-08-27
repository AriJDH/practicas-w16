package interfaces3.clases;

import interfaces3.interfaces.Herviboro;

public class Vaca extends Animal implements Herviboro {
    private String nombre;
    private String tipo;

    public Vaca(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
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
        System.out.println("MUUUUUUU!");
    }

    @Override
    public void comerHierba() {
        System.out.println("Come Hierba");

    }
}
