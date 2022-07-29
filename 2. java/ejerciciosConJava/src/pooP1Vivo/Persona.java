package pooP1Vivo;

public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona(){}

    public Persona(String nombre,int edad,String dni){
        this.nombre=nombre;
        this.edad=edad;
        this.dni = dni;
    }

    public Persona(String nombre,int edad,String dni,double peso,double altura){
        this.nombre=nombre;
        this.edad=edad;
        this.dni=dni;
        this.peso=peso;
        this.altura=altura;
    }

    public int calcularIMC(){
        double imc= this.peso/(Math.pow(this.altura,2));
        if(imc<20){
            return -1;
        } else if (imc>=20 && imc<=25) {
            return 0;
        }else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        if(this.edad>=18){
            return true;
        }else{
            return false;
        }
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
