public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private int peso;
    private int altura;

    public Persona() {

    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, int peso, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double alturaMts = this.altura/100;
        double imc = (this.peso/(Math.pow(alturaMts,2)));
        if(imc<20){
            return -1;
        }else if(imc>=20 && imc <= 25){
            return 0;
        }else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return this.edad > 18;
    }


    public String toString(){
        return "Nombre: "+this.nombre+"\nEdad: "+this.edad+"\nDni: "+this.dni+"\nPeso: "+this.peso+"kg \nAltura: "+this.altura+"cm";
    }
}
