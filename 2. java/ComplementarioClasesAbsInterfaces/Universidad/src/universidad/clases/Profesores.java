package universidad.clases;

import universidad.interfaces.Educacion;
import universidad.interfaces.PersonalUniversidad;

public class Profesores implements PersonalUniversidad, Educacion {

    @Override
    public void cargo() {
            System.out.println("Soy un profesor");
    }

    @Override
    public void educar() {
        System.out.println("Soy un profesor y tengo la labor de enseñar");
    }
}
