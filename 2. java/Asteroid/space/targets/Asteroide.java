package Asteroid.space.targets;

import Asteroid.space.colliders.Collider;

public class Asteroide implements Collider {

    private int x;
    private int y;

    public Asteroide(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer getX() {
        return x;
    }

    @Override
    public Integer getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Asteroide{" +
            "x=" + x +
            ", y=" + y +
            '}';
    }
    
}
