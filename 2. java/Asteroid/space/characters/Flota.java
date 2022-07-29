package Asteroid.space.characters;

import java.util.ArrayList;
import java.util.List;

import Asteroid.space.colliders.Collider;

public class Flota extends Nave{
    List<Nave> naves;

    public Flota() {
        this.naves = new ArrayList<>();
    }

    public Flota(List<Nave> naves) {
        this.naves = naves;
    }

    public List<Nave> getNaves() {
        return naves;
    }

    public void setNaves(List<Nave> naves) {
        this.naves = naves;
    }

    public void addNave(Nave nave) {
        this.naves.add(nave);
    }

    public void removeNave(Nave nave) {
        this.naves.remove(nave);
    }

    @Override
    public double collide(Collider other) {
        double sum = 0;
        for (Nave nave : naves) {
            sum += nave.collide(other);
        }
        return sum / naves.size();
    }

    @Override
    public Integer getX() {
        return null;
    }

    @Override
    public Integer getY() {
        return null;
    }

}
