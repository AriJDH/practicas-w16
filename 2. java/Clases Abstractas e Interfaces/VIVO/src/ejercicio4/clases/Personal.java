package ejercicio4.clases;

public abstract class Personal extends Persona{
    @Override
    public String toString() {
        return "Personal: \n" +
                "Nombre: " + super.getNombre() + " \n"+
                "Edad: " + super.getEdad() + "\n";
    }

    public Personal(String nombre, int edad) {
        super(nombre, edad);
    }

    public Personal() {
    }
}
