package POO.poo1;

public class Persona {
    String nombre;
    int edad;
    char[] dni;
    double peso;
    double altura;

    public Persona(){}

    public Persona(String nombre, int edad, char[] dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, char[] dni_persona, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni_persona;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = peso/ (Math.pow(altura, 2));

        if (imc < 20)
            return -1;
        else if (imc >= 20 && imc <= 25 )
            return 0;
        else
            return 1;
    }

    public boolean esMayorDeEdad(){
        if (edad >= 18)
            return true;
        else
            return false;
    }

    public String toString(){
        String info = "Nombre: " + this.nombre + "\nEdad: " + this.edad + "\nDNI: " + String.valueOf(this.dni) +
                "\nPeso: " + this.peso + "\nAltura: " + this.altura ;

        return info;
    }


}
