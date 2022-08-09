public class Persona {
    String name;
    int age;
    String dni;
    double weight;
    double height;
    Persona() {}
    Persona(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }
    Persona(String name, int age, String dni,double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }
    int calculateIMC() {
        double imc = this.weight/ Math.pow(this.height, 2);
        if(imc < 20) {
            return -1;
        }
        if(20 <= imc && 25 <= imc) {
            return 0;
        }
        return 1;
    }
    boolean isAdult() {
        return this.age <= 18;
    }
    public String toString() {
        String state;
        switch(this.calculateIMC()) {
            case -1:
                state = " bajo de peso";
                break;
            case 0:
                state = " peso saludable";
                break;
            case 1:
                state = " sobre peso";
                break;
            default:
                state = " sin datos de su peso";
        }
        return this.name + "Es una persona" + state;
    }
}
