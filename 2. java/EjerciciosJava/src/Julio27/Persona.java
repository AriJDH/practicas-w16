package Julio27;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private float peso;
    private float altura;

    public Persona() {
        nombre = "";

        edad=0;

        dni = "";

        peso = 0;

        altura = 0;
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public int calcularIMC()
    {
        float indice = peso/((float)Math.pow(altura,2));
        if(indice< 20)
        {
            return -1;
        }else if (indice <= 25)
        {
            return 0;
        }else return 1;
    }
    public boolean esMayorDeEdad()
    {
        if (edad >= 18 ){return true;}
        else return false;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
