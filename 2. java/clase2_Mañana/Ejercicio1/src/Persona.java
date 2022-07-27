public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private int peso;
    private int altura;

    public Persona() {}

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, int peso, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC(){
        double imc = ((this.peso)/(this.altura*this.altura))-(this.peso + this.altura);
            if (imc < 20) {
                System.out.println("IMC: Bajo Peso");
                return -1;
            }
            else if (20 <= imc && imc <=25) {
                System.out.println("IMC: Peso saludable");
                return 1;
            }
            else {
                System.out.println("IMC: Sobrepeso");
                return 0;
            }
    }

    public boolean esMayorDeEdad(){
        return this.edad>=18;
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
