package PooP1Vivo;

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

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Javi", 25, "293558231");
        Persona persona3 = new Persona("Ricardito", 22, "123456789", 70, 1.70);

        //Persona personaFail = new Persona("Pedro",22);

        int imcPersona3 = persona3.calcularIMC();
        System.out.println("Evaluando a "+persona3.toString());
        System.out.println("Segun el imc tu peso es "+ persona3.tipoImc(imcPersona3));
        System.out.println(persona3.esMayorDeEdad() ? "Es mayor de edad" : "es menor de edad" );

    }

    public int calcularIMC() {
        double imc = peso / (Math.pow(altura, 2));

        if (imc < 20)
            return -1;
        else if (imc > 25)
            return 1;
        else return 0;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public String toString() {
        return ("Nombre: " + nombre + " - Edad:  " + edad + " - DNI :" + dni + " - Peso: " + peso + " - Altura" + altura);
    }

    public String tipoImc(int value) {
        if (value < 0)
            return "Bajo";
        if (value > 0)
            return "Sobrepeso";
        else
            return "Saludable";
    }

}
