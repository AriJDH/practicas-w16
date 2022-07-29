package practicesInterfaceAbstract2;

import java.util.List;

public class Curriculum extends Print<Curriculum> {
    private String name;
    private String lastname;
    private String email;
    private List<String> Skills;


    public Curriculum(String name, String lastname, String email, List<String> Skills) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.Skills = Skills;
    }

    public Curriculum() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return Skills;
    }

    public void setSkills(List<String> skills) {
        Skills = skills;
    }

    @Override
    public String toString() {
        return "Curriculum: \n" +
                "Nombre: " + name +
                "\nApellido: " + lastname +
                "\nEmail: " + email +
                "\nHabilidades: " + Skills;
    }
}
