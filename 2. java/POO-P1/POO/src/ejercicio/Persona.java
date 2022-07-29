package ejercicio;

public class Persona {
    String nombre;
    String edad;
    String dni;
    double peso;
    double altura;

    public Persona(){

    }

    public Persona(String nombre, String edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public boolean esMayorEdad(){
        return Integer.parseInt(this.edad) >= 18;
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

}
