package ejercicio2;

public class Player {

    private String name;
    private Spacecraft spacecraft;

    public Player(String name, Spacecraft spacecraft) {
        this.name = name;
        this.spacecraft = spacecraft;
    }

    public String getName() {
        return name;
    }

    public Spacecraft getSpacecraft() {
        return spacecraft;
    }
}
