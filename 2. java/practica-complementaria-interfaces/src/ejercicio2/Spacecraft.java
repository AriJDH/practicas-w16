package ejercicio2;

import java.awt.*;

public interface Spacecraft {
    float score();

    double distanceTo(Point coordinate);

    void incrementScore();
}
