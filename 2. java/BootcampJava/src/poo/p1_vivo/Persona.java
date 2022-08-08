package poo.p1_vivo;

public class Persona {

    private String nombre;

    private String dni;

    private int edad;

    private float peso;

    private float altura;

    public Persona() {
    }

    public Persona(String nombre, String dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, String dni, int edad, float peso, float altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int calcularIMC(double peso, double altura){
        double imc = (peso/(Math.pow(altura,2)));
        int respuesta = 0;
        if(imc<20){
            respuesta = -1;
        } else if (imc >= 20 && imc <= 25) {
            respuesta = respuesta;
        } else if(imc > 25) {
            respuesta = 1;
            }
        return respuesta;
        }
    public boolean esMayorDeEdad(int edad){
        boolean esMayor = false;
        if (edad >= 18) {
            esMayor = true;
        }
        return esMayor;
    }

    public static void toString(Persona persona) {

        int imc = persona.calcularIMC(persona.getPeso(), persona.getAltura());
        String esMayor = "" ;
        if(persona.esMayorDeEdad(persona.getEdad())) {
            esMayor = "Es mayor de edad";
        } else {
            esMayor = "Es menor de edad";
        }
        System.out.println("Datos de Persona \n Nombre: " + persona.getNombre() + "\n DNI: "+ persona.getDni() + "\n Edad: " + persona.getEdad() + " (" + esMayor
                + ") \n Peso: " + persona.getPeso() + "\n Altura: "+persona.getAltura() +"\n IMC = " + imc);
    }
}


