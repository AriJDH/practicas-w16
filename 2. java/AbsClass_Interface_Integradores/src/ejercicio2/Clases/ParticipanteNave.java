package ejercicio2.Clases;

import ejercicio2.AbstractClasses.Participante;

public class ParticipanteNave extends Participante {

    private NaveSimple naveSimple;

    public ParticipanteNave(String nombre, NaveSimple naveSimple, int puntuacion) {
        super(nombre, puntuacion);
        this.naveSimple = naveSimple;
    }

    public NaveSimple getNaveSimple() {
        return naveSimple;
    }

    public void setNaveSimple(NaveSimple naveSimple) {
        this.naveSimple = naveSimple;
    }
}
