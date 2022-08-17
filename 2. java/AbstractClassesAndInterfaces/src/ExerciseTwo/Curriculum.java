package ExerciseTwo;

import java.util.ArrayList;
import java.util.List;

public class Curriculum extends Document implements Printable {
    private Person person;
    private List<String> skills;

    public Curriculum() {
        person = new Person();
        skills = new ArrayList<>();
    }

    public Curriculum(Person person, List<String> skills) {
        this.person = person;
        this.skills = skills;
    }

    @Override
    public void toPrint() {
        System.out.println("Curriculum{" +
                "person=" + person +
                ", skills=" + skills +
                '}');
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
