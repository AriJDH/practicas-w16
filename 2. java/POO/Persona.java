package POO;

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
        double imc = this.peso / (this.altura * this.altura);

        if(imc<20){
            return -1;
        }
        else if(imc>20 && imc<=25){
            return 0;
        }
        else{
            return 1;
        }
    }


    public boolean esMayorDeEdad(){
        return this.edad>=18;
    }

    @Override
    public String toString() {
        return "La informacion de la persona es: " +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura;
    }
}
