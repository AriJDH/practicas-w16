package Asteroid.space.colliders;

import Asteroid.utils.Physics;

public interface Collider {

    default double collide(Collider other) {
        return Physics.distance(getX(), getY(), other.getX(), other.getY());
    }

    Integer getX();

    Integer getY();

}
