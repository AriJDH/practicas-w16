package package1;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona(){

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

    public double calcularIMC(){
        double total = this.peso / (Math.pow(this.altura, 2));
        System.out.println("Indice de masa corporal: ");
        if(total < 20) {
            System.out.print("Bajo peso: ");
            return -1;
        }
        if(total >= 20 && total <= 25) {
            System.out.print("Peso saludable: ");
            return 0;
        }
        else{
            System.out.print("Sobrepeso: ");
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        System.out.print("¿Es "+this.nombre+" mayor de edad?: ");
        return this.edad >= 18;
    }

    @Override
    public String toString() {
        return "Datos de la persona: " +
                "nombre: '" + nombre + '\'' +
                ", edad: " + edad +
                ", dni: '" + dni + '\'' +
                ", peso: " + peso +
                ", altura: " + altura;
    }
}
