package Ejercicio5.clases;

public class Participante {
    private String name;
    private NaveSimple naveSimple;
    private FlotaNave flotaNave;

    public Participante(String name, NaveSimple naveSimple) {
        this.name = name;
        this.naveSimple = naveSimple;
    }

    public Participante(String name, FlotaNave flotaNave) {
        this.name = name;
        this.flotaNave = flotaNave;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NaveSimple getNaveSimple() {
        return naveSimple;
    }

    public void setNaveSimple(NaveSimple naveSimple) {
        this.naveSimple = naveSimple;
    }

    public FlotaNave getFlotaNave() {
        return flotaNave;
    }

    public void setFlotaNave(FlotaNave flotaNave) {
        this.flotaNave = flotaNave;
    }
}
