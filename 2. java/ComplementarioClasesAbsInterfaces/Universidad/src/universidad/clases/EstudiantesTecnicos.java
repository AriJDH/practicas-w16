package universidad.clases;

import universidad.interfaces.PersonalUniversidad;
import universidad.interfaces.Soporte;

public class EstudiantesTecnicos extends Estudiantes implements PersonalUniversidad, Soporte {

    @Override
    public void cargo() {
        System.out.println("Soy un estudiante técnico");
    }

    @Override
    public void soporteTecnico() {
        System.out.println("Soy un estudiante que realiza soporte técnico");
    }
}
