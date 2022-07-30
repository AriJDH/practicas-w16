package Main;

public abstract class Documento implements Imprimible {
    private int numDePags = 1;

    public abstract void mostrarDatos();

    public void setNumDePags(int numDePags) {
        this.numDePags = numDePags;
    }

    public int getNumDePags() {
        return numDePags;
    }
}
