package practica.poo.p1.vivo;

public class Main {
    public static void main(String[] args) {
        Persona personaUno = new Persona();
        Persona personaDos = new Persona("Jose Perez", 20, "123456789");
        Persona personaTres = new Persona("Fernando Garcia", 21, "987654321", 80.0, 1.80);

        //Persona personaError = new Persona("Juan Fernandez", 20);
        //System.out.println(personaTres.calcularIMC());
        //System.out.println(personaTres.esMayorDeEdad());

        if (personaTres.esMayorDeEdad()) {
            System.out.println(personaTres.nombre + " es mayor de edad.");
        } else {
            System.out.println(personaTres.nombre + " es menor de edad.");
        }

        if (personaTres.calcularIMC() == -1) {
            System.out.println(personaTres.nombre + " tiene un peso bajo.");
        } else if (personaTres.calcularIMC() == 0) {
            System.out.println(personaTres.nombre + " tiene un peso saludable.");
        } else {
            System.out.println(personaTres.nombre + " tiene sobrepeso.");
        }
        System.out.println(personaTres);

    }
}
