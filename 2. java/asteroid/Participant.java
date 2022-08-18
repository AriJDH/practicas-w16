package asteroid;

public class Participant implements IParticipant {
    private String name;
    private IFleet fleet;
    public Participant() {}
    public Participant(String name, IFleet fleet) {
        this.name = name;
        this.fleet = fleet;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public IFleet getFleet() {
        return fleet;
    }
    @Override
    public void setFleet(IFleet fleet) {
        this.fleet = fleet;
    }
}
