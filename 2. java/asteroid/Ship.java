package asteroid;

public class Ship implements IShip {
    private Integer x;
    private Integer y;
    private String name;
    public Ship() {}
    public Ship(Integer x, Integer y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }
    public Integer getX() {
        return x;
    }
    public void setX(Integer x) {
        this.x = x;
    }
    public Integer getY() {
        return y;
    }
    public void setY(Integer y) {
        this.y = y;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public Double getDistance(Integer x, Integer y) {
        return Math.abs(Math.sqrt(Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2)));
    }
}
