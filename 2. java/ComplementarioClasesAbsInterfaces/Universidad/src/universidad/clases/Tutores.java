package universidad.clases;

import universidad.interfaces.Educacion;
import universidad.interfaces.PersonalUniversidad;

public class Tutores extends Estudiantes implements PersonalUniversidad, Educacion {

    @Override
    public void cargo() {
        System.out.println("Soy un tutor");
    }

    @Override
    public void educar() {
        System.out.println("Soy un estudiante que tengo la labor adicional de enseñar");
    }
}
