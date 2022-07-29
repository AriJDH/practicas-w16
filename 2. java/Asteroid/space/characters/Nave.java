package Asteroid.space.characters;

import Asteroid.space.colliders.Collider;

public abstract class Nave implements Collider {

  private int x;
  private int y;
  private int score = 0;

  public Nave() {}

  public Nave(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Integer getX() {
    return x;
  }

  public Integer getY() {
    return y;
  }

  public int getScore(){
    return score;
  }

  public void incrementScore(){
    score++;
  }

  @Override
  public String toString() {
    return "Nave{" +
        "x=" + x +
        ", y=" + y +
        ", score=" + score +
        '}';
  }
}
