package universidad.clases;

import universidad.interfaces.PersonalUniversidad;

public class Estudiantes implements PersonalUniversidad {

    @Override
    public void cargo() {
        System.out.println("Soy un estudiante");
    }
}
