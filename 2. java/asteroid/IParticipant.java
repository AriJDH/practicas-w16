package asteroid;

public interface IParticipant {
    public String getName();
    public void setName(String name);
    public IFleet getFleet();
    public void setFleet(IFleet fleet);
}
