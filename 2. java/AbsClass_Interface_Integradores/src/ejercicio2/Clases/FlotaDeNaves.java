package ejercicio2.Clases;

import ejercicio2.Interface.Nave;

import java.util.Arrays;
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
    public Double destruirAsteroide() {
        return flota.stream().mapToDouble(NaveSimple::destruirAsteroide).average().getAsDouble();
    }
}
