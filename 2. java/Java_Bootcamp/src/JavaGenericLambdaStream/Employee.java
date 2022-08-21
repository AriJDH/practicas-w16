package JavaGenericLambdaStream;

public class Employee {

    private int id;
    private String name;
    private String departament;

    public Employee(int id, String name, String departament) {
        this.id = id;
        this.name = name;
        this.departament = departament;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartament() {
        return departament;
    }

    @Override
    public String toString() {
        return "Employee: " +
                "id: " + id +
                "   name: " + name +
                "   departament: " + departament;
    }
}
