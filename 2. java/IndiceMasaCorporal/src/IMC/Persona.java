package IMC;

public class Persona {
    public String nombre;
    public int edad;
    public String dni;
    public double peso;
    public double altura;

    public Persona() { }

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
        double imc = peso/Math.pow(altura, 2);
        int ret = 1;

        if(imc < 20){
            ret = -1;
        }
        else if(imc <= 25){
            ret = 0;
        }

        return ret;
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
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
