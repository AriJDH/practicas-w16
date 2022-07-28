import java.lang.Math;
public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(){
    }
    public Persona(String nombre, int  edad, String  dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni =dni;
    }
    public Persona(String nombre, int  edad, String  dni, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int IMC(){
        double imc =  peso/(Math.pow(altura, 2.0));
        if (imc < 20 ){
            return -1;
        } else if (imc > 20 && imc <25) {
            return 0;
        }else {
            return 1;
        }
    }
    public boolean esMayorDeEdad(){
        if (edad > 18.0){
            return true;
        }else {
            return false;
        }
    }
//podes preguntar si son nulos y vacios y mostras los que queres o sobrecargas el metodo
}

