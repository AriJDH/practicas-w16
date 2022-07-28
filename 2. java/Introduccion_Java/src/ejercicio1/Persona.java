package ejercicio1;

public class Persona {

    //Ejercicio 1: atributos de la clase Persona
    protected String nombre;
    protected int edad;
    protected String dni;
    protected Double peso;
    protected Double altura;

    //Ejercicio 2: constructores de la clase
    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, Double peso, Double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    //Ejercicio 5: Creación de métodos de la clase
    public int calcularIMC(){
        Double personaIMC = this.getPeso() / Math.pow(this.getAltura(), 2);
        int salida;
        if (personaIMC < 20){
            salida = -1;
        }
        else if (personaIMC >= 20 && personaIMC <= 25){
            salida = 0;
        }
        else{
            salida = 1;
        }
        return salida;
    }

    public boolean esMayorDeEdad(){
        if (this.getEdad() >= 18){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "********* Ficha de la Persona **********" + "\n"
                + "Nombre: " + this.getNombre() + "\n"
                + "Edad: " + this.getEdad() + " años" + "\n"
                + "DNI: " + this.getDni() + "\n"
                + "Peso: " + this.getPeso() + " kilogramos" + "\n"
                + "Estatura: " + this.getAltura() + " metros" + "\n";
    }
}
