package poo_p1_vivo;

public class Persona {
    public String nombre;
    public int edad;
    public String dni;
    public float peso;
    public float altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        float imc = (this.peso/(this.altura + this.altura));
        if (imc < 20){
            return -1;
        } else if (imc >= 20 && imc <= 25){
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return (this.edad >= 18);
    }

    @Override
    public String toString() {
        int imc = this.calcularIMC();
        String imcMessage = imc == -1 ? "Bajo peso" : imc == 0 ? "Peso saludable" : "Sobrepeso";
        String esMayorMessage = this.esMayorDeEdad() ? "Es mayor de edad" : "No es mayor de edad";

        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}' +
                " Tiene " + imcMessage + " y " + esMayorMessage;
    }
}
