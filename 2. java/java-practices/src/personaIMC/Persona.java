package personaIMC;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso; // Expresado en kilogramos (kg)
    private double altura; // Expresado en metros (mts)

    public Persona(){
        this.nombre = "";
        this.edad = 0;
        this.dni = "";
        this.peso = 0.0;
        this.altura = 0.0;
    }

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = 0.0;
        this.altura = 0.0;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = (this.peso / (Math.pow(this.altura, 2)));

        int valorDeReferencia;
        if(imc < 20){
            valorDeReferencia = -1;
        }else if(20 <= imc && imc <= 25){
            valorDeReferencia = 0;
        }else{
            valorDeReferencia = 1;
        }

        return valorDeReferencia;
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }

    @Override
    public String toString(){
        String datos = "Nombre: " + this.nombre + ", Edad: " + this.edad + " años" + ", DNI: " + this.dni + ", Peso: " + this.peso + ", Altura: " + this.altura + ".";
        return datos;
    }
}
