package ejercicio;

public class Persona {
    String nombre;
    String dni;
    int edad;
    double peso;
    double altura;

    public Persona(){};

    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, String dni, int edad, double peso, double altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double valor = (peso / (Math.pow(altura, 2))) - (peso + altura);
        if (valor < 20){
            return -1;
        }else if (valor <= 25){
            return 0;
        }else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return edad>=18;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nDNI: " + dni + "\nEdad: " + edad + "\nPeso: " + peso + " Kg." + "\nAltura: "+ altura + " m.";
    }
}
