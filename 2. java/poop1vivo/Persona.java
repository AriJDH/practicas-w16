package p1pg;

public class Persona {

    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona() {
    }

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

    public int calcularIMC() {
        double valueIMC = this.peso/Math.pow(this.altura, 2);

        if(valueIMC < 20){
            System.out.println("Bajo peso");
            return -1;
        }else if(valueIMC >= 20 && valueIMC <= 25){
            System.out.println("Peso Saludable");
            return 0;
        }else {
            System.out.println("Sobre peso");
            return 1;
        }
    }

    public boolean esMayorDeEdad() {

        boolean esMayor = false;
        if(this.edad >= 18) {
            esMayor = true;
        }

        return esMayor;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
