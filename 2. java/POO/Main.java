package POO;

public class Main {
    public static void main(String[] args) {
        Persona personaConstructorSinParametros = new Persona();
        Persona personaConstructorParametrosIncompleto = new Persona("Jonathan",25,"4.740.193-2" );
        Persona personaConstructorParametrosCompleto = new Persona("Gabriel", 26, "5.879.091-7",82.5,1.72);
        //Persona personaFaltanParametros = new Persona("Juan",25);

        int imc = personaConstructorParametrosCompleto.calcularIMC();
        if(imc==-1){
            System.out.println("Bajo peso");
        } else if (imc==0) {
            System.out.println("Peso saludable");
        }
        else{
            System.out.println("Sobrepeso");
        }
        System.out.println(personaConstructorParametrosCompleto.esMayorDeEdad());
        System.out.println(personaConstructorParametrosCompleto.toString());
    }
}
