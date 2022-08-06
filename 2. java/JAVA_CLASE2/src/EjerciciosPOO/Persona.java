package EjerciciosPOO;

public class Persona {

    String nombre;
    String edad;
    String dni;
    Double peso;

    Double altura;

    //Constructor vacio
    public Persona(){

    }

    //Constructor con parametros

    public Persona(String nombre, String edad, String dni, Double peso, Double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    //Constructor con parametros nombre, edad y dni

    public Persona(String nombre, String edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
    }

    //Declaro los metodos

    public double calcularIMC(){

        Double imc;

        double alturacuadrado = Math.pow(altura, 2);
        imc = (peso/alturacuadrado);

        //if (imc<20){
          //  return -1;
        //}else if (imc >= 20 && imc <= 25){
          //  return 0;
        //}else{
            //return 1;
        //}
        return imc;
    }

    public boolean esMayorDeEdad(){

        int edad1 = Integer.parseInt(edad);
        return edad1 >= 18;
    }

    public String toString(String nombre, String edad, String dni, Double peso, Double altura, Double imc, boolean esMayorDeEdad){

    return "hola";

    }

    public String toString(double imc, boolean mayor){

        //convierto un double a un entero
        int inum = (int)imc;

        if (inum<20){
            if (mayor == true) {
                return "nombre: " + this.nombre + " edad: " + this.edad + " dni: " +  this.dni + " peso: " + this.peso
                        +" altura: " +  this.altura + " Persona mayor de edad con un imc de: " + inum
                        + " tiene un nivel de peso: BAJO PESO";
            }
        }else if (inum >= 20 && inum <= 25){
            return " nombre: " + this.nombre + " edad: " + this.edad + " dni: " +  this.dni + " peso: " + this.peso
                    +" altura: " +  this.altura + inum + "  tiene un nivel de peso: PESO SALUDABLE";
        }
            return " nombre: " + this.nombre + " edad: " + this.edad + " dni: " +  this.dni + " peso: " + this.peso
                +" altura: " +  this.altura + inum + "  tiene un nivel de peso: SOBREPESO";
    }

}
