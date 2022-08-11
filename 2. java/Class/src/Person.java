public class Person {
    private String name;
    private int edad;
    private String dni;
    private int weight;
    private double height;

    public Person() {
    }

    public Person(String name, int edad, String dni) {
        this.name = name;
        this.edad = edad;
        this.dni = dni;
    }

    public Person(String name, int edad, String dni, int weight, double height) {
        this.name = name;
        this.edad = edad;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public double cacularIMC() {
        double imc = weight / (height*height);
        int ind = 0;

        if (imc < 20) {
            ind = -1;
        } else if (imc >= 20 && imc <= 25) {
            ind = 0;
        } else if (imc > 25) {
            ind = 1;
        }

        return ind;
    }

    public boolean esMayorDeEdad() {
        if (edad > 18) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
