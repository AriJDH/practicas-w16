package ExerciseTwo.actors;

import ExerciseTwo.interfaces.Imprimible;

public abstract class Documento implements Imprimible {

    protected String type;

    public Documento(String type) {
        this.type = type;
    }

    protected String getType() {
        return type;
    }
}
