package ejercicio2;

import java.awt.*;
import java.util.List;

public class ComplexOfSpacecraft implements Spacecraft {

    private Integer score;
    private final List<Spacecraft> spacecraftList;

    public ComplexOfSpacecraft(List<Spacecraft> spacecraftList){
        this.spacecraftList = spacecraftList;
        this.score = 0;
    }

    @Override
    public float score() {
        return score;
    }

    @Override
    public double distanceTo(Point coordinate) {
        return spacecraftList.stream().mapToDouble(spacecraft -> spacecraft.distanceTo(coordinate)).sum() / spacecraftList.size();
    }

    @Override
    public void incrementScore() {
        score += 1;
    }


}
