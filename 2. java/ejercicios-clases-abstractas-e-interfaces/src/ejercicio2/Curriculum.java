package ejercicio2;

import java.time.LocalDate;
import java.util.List;

public class Curriculum implements Printable {

    private String fullName;
    private LocalDate birthDate;
    private List<String> skills;

    public Curriculum(String fullName, LocalDate birthDate, List<String> skills) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.skills = skills;
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", skills=" + skills +
                '}';
    }
}
