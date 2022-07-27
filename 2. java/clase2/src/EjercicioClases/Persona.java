package EjercicioClases;

public class Persona {
    String nombre;
    int edad;
    String dni;
    int peso;
    int altura;
    public Persona(){

    }
    public Persona(String nombre,int edad,String dni){

    }
    public Persona(String nombre,int edad,String dni,int peso,int altura){

    }
    public int  calcularIMC(){
        double calcula=peso/(Math.pow(altura,2));
        if (calcula<20){
            return -1;
        } else if (calcula>=20  & calcula<=25) {
            return 0;
        } else {
            return 1;
        }
    }
    public boolean esMayorDeEdad(){
        if (edad>18){
            return true;
        }
        return false;
    }
    public String toStirng(){
        return "nombre: "+nombre + "edad: "+edad + "dni: " + dni +  "peso: "+ peso + "altura: " + altura;
    }

    public static void main(String[] args) {
    Persona persona=new Persona();
    Persona personaMed=new Persona("emanuel rivero",21,"41704652");
    Persona personaFull=new Persona("Jorge rodolfo",44,"40914753",100,192);
    System.out.println(personaMed.toStirng());
    System.out.println(personaFull.toStirng());
    System.out.println("indice de masa corporal: "+personaFull.calcularIMC());
    System.out.println("es mayor: "+ personaFull.esMayorDeEdad());


    }
}
