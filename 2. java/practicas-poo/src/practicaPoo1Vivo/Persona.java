package practicaPoo1Vivo;

public class Persona {
    private String nombre, dni;
    private int edad;
    private double peso, altura;

    public Persona() {

    }

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

    public Integer calcularIMC() {
        double indiceMasaCorporal = peso / Math.pow(altura, 2f);
        if (indiceMasaCorporal < 20) {
            return -1;
        } else if (indiceMasaCorporal >= 20 && indiceMasaCorporal <= 25){
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
