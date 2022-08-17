public class Persona {
    //Ejercicio1: sería la creación de la clase (public class Persona) y la definición de sus atributos
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    //Ejercicio 2: constructores
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

    //Ejercicio 5 creación de métodos

    //Método para calcular el IMC
    public int calcularIMC(double peso, double altura) {

        int resultado;

        double imc = peso / Math.pow((altura / 100),2);

        if (imc < 20) {
            resultado = -1;
        } else if (imc >= 20 && imc <= 25) {
            resultado = 0;
        } else { //if(imc > 25){
            resultado = 1;
        }
        return resultado;
    }

    //Método para verificar si la persona es mayor o menor de edad
    public boolean esMayorDeEdad(int edad){
        if (edad >= 18){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "La Persona Creada es " + nombre + ", tiene " + edad + " años, su DNI es " + dni + ", Pesa " + peso + " Kgs" + " y Mide " + altura + " cms.";
    }
}


