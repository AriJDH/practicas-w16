public class Persona {

    String nombre;
    int edad;
    String dni;
    float peso;
    float altura;

    public Persona(){

    }
    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, float peso, float altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;

    }

    public int calcularIMC(){
        float imc = peso/(altura*altura);

        int retval = 0;

        if(imc<20){
            retval = -1;
        }
        else if(imc>25){
            retval = 1;
        }
        else{
            retval = 0;
        }

        return retval;
    }
    public boolean esMayorDeEdad(){
        boolean esMayor = false;
        if (edad >= 18)
        {
            esMayor = true;
        }
        return esMayor;
    }

    public String toString(){
        String datPer="";

        datPer = nombre + " " + edad + " " + dni + " " + peso + " " + altura;

        return datPer;
    }


    public static void main(String[] args) {
        Persona per1 = new Persona();
        Persona per2 = new Persona("Pedro picapiedra",21,"22233344");
        Persona per3 = new Persona("Bart Simpson",15,"55555444",70,1.70f);

        int resulIMC = per3.calcularIMC();

        switch (resulIMC){
            case 0:
                System.out.println("Peso saludable.");
                break;
            case 1:
                System.out.println("Sobrepeso.");
                break;
            case -1:
                System.out.println("Bajo peso.");
                break;
        }

        if(per3.esMayorDeEdad()) {
            System.out.println("Es mayor de edad.");
        }else{
            System.out.println("Es menor de edad.");
        }
    }
}
