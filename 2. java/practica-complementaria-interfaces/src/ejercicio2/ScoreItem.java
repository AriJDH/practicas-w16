package ejercicio2;

import java.awt.*;

public class ScoreItem {

    private final Spacecraft spacecraft;
    private final Point point;

    public ScoreItem(Spacecraft spacecraft, Point point) {
        this.spacecraft = spacecraft;
        this.point = point;
    }

    @Override
    public String toString() {
        return "ScoreItem{" +
                "spacecraft=" + spacecraft +
                ", point=" + point +
                '}';
    }
}
