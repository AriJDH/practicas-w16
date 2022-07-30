package Main;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    // Constructores
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

    // Setters y Getters

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    // Métodos
    public short calcularIMC() {
        double IMC = 0;

        try {
            IMC = this.peso / Math.pow(this.altura, 2);
        } catch ( ArithmeticException exception){
            System.out.println(exception.getMessage());
            System.out.println("La altura no puede ser 0.");
        }

        if(IMC < 20)
            return -1;
        else if(IMC > 25)
            return 1;

        return 0;
    }

    public boolean esMayorDeEdad() {
        return (this.edad >= 18);
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ",\n" +
                "edad=" + edad + ",\n" +
                "dni='" + dni + ",\n" +
                "peso=" + peso + ",\n" +
                "altura=" + altura;
    }
}
