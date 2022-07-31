package juego;

import juego.interfaces.Naves;

import java.util.ArrayList;
import java.util.List;

public class flota_naves implements Naves {

    List<NaveSimple> navesSimples = new ArrayList<NaveSimple>();
    private static double puntuacion = 0;

    public flota_naves(List<NaveSimple> navesSimples) {
        this.navesSimples = navesSimples;
    }

    public List<NaveSimple> getNavesSimples() {
        return navesSimples;
    }

    public void setNavesSimples(List<NaveSimple> navesSimples) {
        this.navesSimples = navesSimples;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public double calcularDistancia(int x2, int y2){
        double suma = 0;
        for(NaveSimple nave: navesSimples){
            suma += nave.calcularDistancia(x2,y2);
        }
        double promedio = suma/this.navesSimples.size();
        return promedio;
    }
}
