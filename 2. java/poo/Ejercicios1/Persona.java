package Ejercicios1;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona() {
    }// este en teoria no es necesario pq se hace por defecto, pero lo dejo por si acaso

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = peso / (altura * altura);
        if (imc < 20) {
            return -1;
        } else if (imc <= 25 && imc >= 20) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        if (edad >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return "Nombre: " + nombre + " - Edad: " + edad + " - DNI: " + dni + " - Peso: " + peso + " - Altura: " + altura;
    }
}
