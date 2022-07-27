public class PersonSmall extends Person {

    public PersonSmall() {
        super();
    }

    @Override
    public double CalculateSubscription() {
        return this.getAge() > 18 ? 1500 : 1300;
    }
}
