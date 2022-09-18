package ejercicio2.Clases;

import ejercicio2.AbstractClasses.Participante;

public class ParticipanteFlota extends Participante {

    private FlotaDeNaves flotaDeNaves;

    public ParticipanteFlota(String nombre, FlotaDeNaves flotaDeNaves, int puntuacion) {
        super(nombre, puntuacion);
        this.flotaDeNaves = flotaDeNaves;
    }

    public FlotaDeNaves getFlotaDeNaves() {
        return flotaDeNaves;
    }

    public void setFlotaDeNaves(FlotaDeNaves flotaDeNaves) {
        this.flotaDeNaves = flotaDeNaves;
    }
}
