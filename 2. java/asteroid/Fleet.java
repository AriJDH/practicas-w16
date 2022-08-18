package asteroid;

import java.util.ArrayList;
import java.util.List;


public class Fleet implements IFleet {
    public List<IShip> ships = new ArrayList<>();
    private Integer score;

    public Fleet() {}
    @Override
    public Double getDistanceAverage(Integer x, Integer y) {
        return this.ships
                .stream()
                .mapToDouble(value -> value.getDistance(x, y))
                .reduce(0d, (a, b) -> a + b) / this.ships.size();
    }
    @Override
    public void addShip(IShip ship) {
        this.ships.add(ship);
    }
    @Override
    public void addScore() {
        this.score++;
    }
    @Override
    public Integer getScore() {
        return score;
    }
    @Override
    public void setScore(Integer score) {
        this.score = score;
    }
}
