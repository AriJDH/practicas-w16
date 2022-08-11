package poo_p1_vivo;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(){
    }

    public Persona(String nombre, int edad, String dni){
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
        double imc = peso/(Math.pow(altura,2));
        if (imc < 20) return -1;
        else if(20 >= imc && imc <=25 ) return 0;
        return 1;
    }

    public boolean esMayorDeEdad(){
        return edad>=18;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s, Edad: %s, DNI: %s, Peso: %.1f y Altura: %.2f", nombre, edad, dni, peso, altura);
    }
}
