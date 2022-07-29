package ejercicio4.clases;

import ejercicio4.interfaces.SoporteTecnico;

public class EstudianteTecnico extends Estudiante implements SoporteTecnico {
    public EstudianteTecnico(String nombre, int edad) {
        super(nombre, edad);
    }

    public EstudianteTecnico() {
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void darSoporteTecnico(String algo) {
        System.out.println("El estudiante tecnico "+super.getNombre()+" está dando soporte tecnico a " + algo);
    }
}
