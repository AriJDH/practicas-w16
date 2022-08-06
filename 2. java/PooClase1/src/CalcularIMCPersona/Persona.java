package CalcularIMCPersona;

public class Persona {

    String nombre;
    String edad;
    String dni;
    double peso;
    double altura;

    public Persona() {
    }

    public Persona(String nombre, String edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, String edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    // peso/(altura^2)
    public int calcularIMC() {
        double imc = this.peso / Math.pow(this.altura, 2);

        if (imc < 20) return -1;
        else if (imc >= 20 || imc <= 25) return 0;
        else return 1;
    }

    public boolean esMayorDeEdad() {
        int edad = Integer.parseInt(this.edad);
        if (edad < 18) return false;
        else return true;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad='" + edad + '\'' +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
