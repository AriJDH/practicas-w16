import java.util.ArrayList;
import java.util.List;

public class Business {

    private List<Person> subscriptors;
    private static final Business mySystem = new Business();


    public Business() {
        subscriptors = new ArrayList<>();
    }

    public List<Person> getSubscriptors() {
        return subscriptors;
    }

    public static Business getMySystem() {
        return mySystem;
    }


    public boolean addSubscriptor(String category, String name, String lastName, String dni, int age, String celPhone, String emergencyNumber, String bloodyType) {

        if (category.equalsIgnoreCase("chico")) {
            PersonSmall person = new PersonSmall();
            person.setAge(age);
            person.setName(name);
            person.setLastName(lastName);
            person.setEmergencyNumber(emergencyNumber);
            person.setDni(dni);
            person.setCelPhone(celPhone);
            person.setBloodyType(bloodyType);
            if (person.validateFields() && !getSubscriptors().contains(person)) {
                person.setSubscriptionID();
                subscriptors.add(person);
                return true;
            }
        }

        if (category.equalsIgnoreCase("medio")) {
            PersonMedium person = new PersonMedium();
            person.setAge(age);
            person.setName(name);
            person.setLastName(lastName);
            person.setEmergencyNumber(emergencyNumber);
            person.setDni(dni);
            person.setCelPhone(celPhone);
            person.setBloodyType(bloodyType);
            if (person.validateFields() && !getSubscriptors().contains(person)) {
                person.setSubscriptionID();
                subscriptors.add(person);
                return true;

            }
        }
        if (category.equalsIgnoreCase("avanzado")) {
            PersonExpert person = new PersonExpert();
            person.setAge(age);
            person.setName(name);
            person.setLastName(lastName);
            person.setEmergencyNumber(emergencyNumber);
            person.setDni(dni);
            person.setCelPhone(celPhone);
            person.setBloodyType(bloodyType);
            if (person.validateFields() && !getSubscriptors().contains(person)) {
                person.setSubscriptionID();
                subscriptors.add(person);
                return true;
            }
        }
        return false;

    }

    public boolean removeSubscriptor(int id) {

        for (int i = 0; i <= subscriptors.size() - 1; i++) {
            if (subscriptors.get(i).getId() == id) {
                subscriptors.remove(i);
                return true;
            }
        }
        return false;
    }

    public void printSubscriptors(String category) {

        for (Person person : getListBySubscription(category)) {
            System.out.print(person);
        }


    }

    private List<Person> getListBySubscription(String category) {
        List<Person> showSubscriptions = new ArrayList<>();

        for (Person person : subscriptors) {
            if (person instanceof PersonMedium && category.equalsIgnoreCase("medium")) {
                showSubscriptions.add(person);
            }
            if (person instanceof PersonSmall && category.equalsIgnoreCase("chico")) {
                showSubscriptions.add(person);
            }
            if (person instanceof PersonSmall && category.equalsIgnoreCase("avanzado")) {
                showSubscriptions.add(person);
            }

        }
        return showSubscriptions;


    }


    public double calculateSubscriptionById(int id) {

        for (int i = 0; i <= subscriptors.size() - 1; i++) {
            if (subscriptors.get(i).getId() == id) {
                return subscriptors.get(i).CalculateSubscription();
            }
        }
        return 0.0;
    }


}
