package ExerciseTwo;

public class Person {
    private String dni;
    private String name;
    private String lastName;
    private int age;
    private String cellPhone;

    public Person() {
    }

    public Person(String dni, String name, String lastName, int age, String cellPhone) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.cellPhone = cellPhone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", cellPhone='" + cellPhone + '\'' +
                '}';
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }
}
