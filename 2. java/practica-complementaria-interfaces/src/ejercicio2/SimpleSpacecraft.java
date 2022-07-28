package ejercicio2;

import java.awt.*;

public class SimpleSpacecraft implements Spacecraft {

    private final String name;
    private final Point location;

    private Integer score;

    public SimpleSpacecraft(String name, Point location) {
        this.name = name;
        this.location = location;
        score = 0;
    }

    @Override
    public float score() {
        return score;
    }

    @Override
    public double distanceTo(Point coordinate) {
        return Math.sqrt(
                Math.pow(location.getX() - coordinate.getX(), 2)
                        + Math.pow(location.getY() - coordinate.getY(), 2));
    }

    @Override
    public void incrementScore() {
        score += 1;
    }

    public String name() {
        return name;
    }

}
