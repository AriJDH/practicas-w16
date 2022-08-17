package Ejercicio5.clases;

public class Participante {
    private String name;
    private Composite composite;

    public Participante(String name, Composite composite) {
        this.name = name;
        this.composite = composite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Composite getComposite() {
        return composite;
    }

    public void setComposite(Composite composite) {
        this.composite = composite;
    }
}
