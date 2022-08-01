package Poo;

public class Persona {
    String nombre;
    int edad;
    int dni;
    float peso;
    float altura;

    public Persona() {

    }

    public Persona(String nombre, int edad, int dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, int dni, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularMC() {
        double imc;

        imc = peso / (Math.pow(altura, 2));

        if (imc < 20) {
            return -1;
        } else if (imc <= 25 && imc >= 20) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorEdad(){
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni=" + dni +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}







