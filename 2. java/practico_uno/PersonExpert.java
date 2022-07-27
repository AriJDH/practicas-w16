public class PersonExpert extends Person {


    public PersonExpert() {
        super();
    }

    @Override
    public double CalculateSubscription() {
        return this.getAge() > 18 ? 2800 : 0;
    }
}
