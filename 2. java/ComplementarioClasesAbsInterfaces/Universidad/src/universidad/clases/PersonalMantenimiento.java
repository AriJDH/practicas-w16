package universidad.clases;

import universidad.interfaces.PersonalUniversidad;

public class PersonalMantenimiento implements PersonalUniversidad {

    @Override
    public void cargo() {
        System.out.println("Soy parte del personal de mantenimiento");
    }
}
