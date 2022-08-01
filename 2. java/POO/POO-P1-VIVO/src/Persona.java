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

    public int calcularIMC(){
        double imc = peso/Math.pow(altura,2);
        if(imc < 20){
            return -1;
        }else if (imc>= 20 && imc <= 25) {
                return 0;
            } else {
                return 1;
            }
    };

    public boolean esMayorDeEdad(){
        if(edad >= 18) return true;
        return false;
    }

    public String toString(){
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nDNI: " + dni +"\nPeso: " + peso + "\nAltura: " + altura;


    }

}
