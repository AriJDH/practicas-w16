package ejercicio1;

public class Persona {
    private String name;//variables de instancia
    private String lastName;
    private int age;
    private String dni;
    private double weight;
    private double height;

    public Persona (){
    }

    public Persona (String name, String lastName, int age, String dni){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.dni = dni;
    }

    public Persona (String name, String lastName, int age, String dni, double weight, double height){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }

    public int calcularIMC(){
        double imcCalculo = 0;

        imcCalculo = (weight/ (Math.pow(height, 2)));//Math.pow es un metodo de clase, de la clase java.lang

        if (imcCalculo < 20 || height == 0){
            return -1; //bajo de peso
        } else if(imcCalculo >= 20 && imcCalculo <= 25){
            return 0;//peso saludable
        } else {
            return 1;//sobrepeso
        }
    }

    public boolean esMayorDeEdad(){
        if (age >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return name + " " + lastName + ", edad: " + age + ", dni: " + dni + " , peso: " + weight + " y altura: " + height;
    }
}
