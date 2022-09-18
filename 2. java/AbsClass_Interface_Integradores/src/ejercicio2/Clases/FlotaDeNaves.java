package ejercicio2.Clases;

import ejercicio2.Interfaces.Nave;

import java.util.List;

public class FlotaDeNaves implements Nave {

    private List<NaveSimple> flota;

    public FlotaDeNaves(List<NaveSimple> flota) {
        this.flota = flota;
    }

    public List<NaveSimple> getFlota() {
        return flota;
    }

    public void setFlota(List<NaveSimple> flota) {
        this.flota = flota;
    }

    @Override
    public Double destruirAsteroide(Asteroide asteroid) {
        //return flota.stream().mapToDouble(NaveSimple::destruirAsteroide).average().getAsDouble();
        double acumulador = 0.0;
        int index = 0;
        for (NaveSimple naves : getFlota()){
            acumulador += Math.sqrt(Math.pow(flota.get(index).getX() - asteroid.getPosx(), 2) + Math.pow(flota.get(index).getY() - asteroid.getPosy(), 2));
            index++;
        }
        return acumulador / index;
    }
}
