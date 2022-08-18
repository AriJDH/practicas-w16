package asteroid;

public interface IFleet {
    Double getDistanceAverage(Integer x, Integer y);
    void addShip(IShip ship);
    void addScore();
    Integer getScore();
    void setScore(Integer score);
}
