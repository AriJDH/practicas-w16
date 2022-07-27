public class Persona {
    String nombre;
    String dni;
    int edad;
    int peso;
    float altura;

    public Persona(){
    }

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, String dni, int edad, int peso, float altura){
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        float imc = peso/(altura*altura);

        if(imc<20) return -1;
        if(imc>=20 && imc<=25) return 0;
        return 1;
    }

    public boolean esMayorDeEdad(){
        if(edad>=18) return true;
        return false;
    }

    public void mostrarInfo(){
        System.out.println("Datos de la persona");
        System.out.println("Nombre: "+nombre
                +"\nDNI: "+dni
                +"\nEdad: "+edad+" años"
                +"\nPeso: "+peso+"Kg"
                +"\nAltura: "+altura+"m");
    }

}
