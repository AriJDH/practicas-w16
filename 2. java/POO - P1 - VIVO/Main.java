package EjerciciosPoo;

public class Main {

    public static void main(String[] args) {

        Persona jack = new Persona();
        Persona marco = new Persona("marco",22,"53317532");
        Persona aurelio = new Persona("Aurelio",18,"48777532",68,1.76);


        int imc =  aurelio.cacularIMC();
        System.out.println(imc);

        boolean esMayorDeEdad = aurelio.esMayorDeEdad();

        if(imc == -1){
            System.out.println(aurelio.getNombre() + " tiene peso bajo");
        }else if(imc == 0) {
            System.out.println(aurelio.getNombre() + " tiene un peso saludable");
        }else
            System.out.println(aurelio.getNombre() + " tiene un peso alto");

        if(esMayorDeEdad){
            System.out.println(aurelio.getNombre() + " es mayor de edad");
        }else
            System.out.println(aurelio.getNombre() + " es menor de edad");

        System.out.println(aurelio.toString());




    }

}
