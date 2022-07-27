public class PersonMedium extends Person {


    public PersonMedium() {
        super();
    }

    @Override
    public double CalculateSubscription() {
        return this.getAge() > 18 ? 2300 : 2000;
    }
}
